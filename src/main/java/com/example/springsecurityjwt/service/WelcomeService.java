package com.example.springsecurityjwt.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

    @PreAuthorize("hasAuthority('USER')")
    public String welcomeUser() {
        return "Welcome User!";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    public String welcomeAdmin() {
        return "Welcome Admin!";
    }
}
