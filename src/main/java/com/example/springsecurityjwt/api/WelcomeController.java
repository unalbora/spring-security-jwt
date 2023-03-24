package com.example.springsecurityjwt.api;

import com.example.springsecurityjwt.service.WelcomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
@RequiredArgsConstructor
public class WelcomeController {

    private final WelcomeService welcomeService;

    @GetMapping("/user")
    public ResponseEntity<String> welcomeUser() {
        String welcomeMessage = welcomeService.welcomeUser();
        return ResponseEntity.ok(welcomeMessage);
    }

    @GetMapping("/admin")
    public ResponseEntity<String> welcomeAdmin() {
        String welcomeMessage = welcomeService.welcomeAdmin();
        return ResponseEntity.ok(welcomeMessage);
    }
}
