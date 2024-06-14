package mr.pharmaproche.pharmaproche.service;

import mr.pharmaproche.pharmaproche.model.AppUser;
import mr.pharmaproche.pharmaproche.registration.LoginRequest;
import mr.pharmaproche.pharmaproche.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public Map<String, String> authenticate(LoginRequest loginRequest) {
        Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
        if(authentication.isAuthenticated()) {
            return jwtService.generateJwt((AppUser) authentication.getPrincipal());
        }
        return null;
    }

}
