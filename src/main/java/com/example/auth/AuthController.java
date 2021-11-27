package com.example.auth;

import com.example.auth.exception.LoginException;
import com.example.auth.exception.RegistrationException;
import com.example.auth.model.ErrorResponse;
import com.example.auth.model.TokenResponse;
import com.example.auth.model.User;
import com.example.auth.service.TokenService;
import com.example.auth.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Viacheslav Shago
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final ClientService clientService;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody User user) {
        clientService.register(user.getClientId(), user.getClientSecret());
        return ResponseEntity.ok("Registered");
    }

    @PostMapping("/token")
    public TokenResponse getToken(@RequestBody User user) {
        clientService.checkCredentials(user.getClientId(), user.getClientSecret());
        return new TokenResponse(tokenService.generateToken(user.getClientId()));
    }

    @ExceptionHandler({RegistrationException.class, LoginException.class})
    public ResponseEntity<ErrorResponse> handleUserRegistrationException(RuntimeException ex) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse(ex.getMessage()));
    }
}
