package com.example.springsecurityjwt.dao;

import com.example.springsecurityjwt.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserDao {

    private Map<String, User> users;

    @PostConstruct
    public void init() {
        users = new HashMap<>();
    }

    public Optional<User> findByUsername(String username) {
        if (users.containsKey(username)) {
            return Optional.of(users.get(username));
        }
        throw new UsernameNotFoundException(username);
    }

    public void saveUser(User user) {
        users.put(user.getUsername(), user);
    }
}
