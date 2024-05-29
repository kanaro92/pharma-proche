package mr.pharmaproche.pharmaproche.service;

import mr.pharmaproche.pharmaproche.collection.User;
import mr.pharmaproche.pharmaproche.collection.dto.UserDTO;
import mr.pharmaproche.pharmaproche.mapper.UserMapper;
import mr.pharmaproche.pharmaproche.registration.LoginRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private final JwtEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    public AuthService(JwtEncoder encoder, AuthenticationManager authenticationManager, UserMapper userMapper) {
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
        this.userMapper = userMapper;
    }

    public UserDTO authenticate(LoginRequest userLogin) {
        Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.email(), userLogin.password()));
        UserDTO userDTO = this.userMapper.userToDTO((User) authentication.getPrincipal());
        String token = this.generateToken(authentication);
        userDTO.setToken(token);
        return userDTO;
    }

    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(Duration.ofHours(1)))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();
        return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

}
