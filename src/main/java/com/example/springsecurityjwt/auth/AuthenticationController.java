package com.example.springsecurityjwt.auth;

import com.example.springsecurityjwt.dto.LoginRequest;
import com.example.springsecurityjwt.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        String responseMessage = authService.register(request);
        return ResponseEntity.ok(responseMessage);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String jwtToken = authService.login(request);
        return ResponseEntity.ok(jwtToken);
    }
}
