package com.example.springsecurityjwt.auth;

import com.example.springsecurityjwt.dao.UserDao;
import com.example.springsecurityjwt.dto.LoginRequest;
import com.example.springsecurityjwt.dto.RegisterRequest;
import com.example.springsecurityjwt.entity.Role;
import com.example.springsecurityjwt.entity.User;
import com.example.springsecurityjwt.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    public String login(LoginRequest request) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        Authentication authentication = authenticationManager.authenticate(authToken);
        if (authentication.isAuthenticated()) {
            return tokenService.generateToken(authentication);
        }
        return null;
    }

    public String register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.valueOf(request.getRole()))
                .build();
        userDao.saveUser(user);
        return "Registered!";
    }
}
