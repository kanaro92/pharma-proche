package mr.pharmaproche.pharmaproche.controller;

import lombok.extern.slf4j.Slf4j;
import mr.pharmaproche.pharmaproche.model.dto.UserDTO;
import mr.pharmaproche.pharmaproche.registration.LoginRequest;
import mr.pharmaproche.pharmaproche.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/pharma-proche/login")
@Slf4j
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> auth(@RequestBody LoginRequest loginRequest) throws AuthenticationException {
//        UserDTO userDTO = null;
//        try {
//            userDTO = authService.authenticate(loginRequest);
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(userDTO);
//        }
        return ResponseEntity.status(HttpStatus.OK).body(authService.authenticate(loginRequest));
    }

}
