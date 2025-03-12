package com.subscriptions.app.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.subscriptions.app.controller.RegisterRequest;
import com.subscriptions.app.model.User;
import com.subscriptions.app.repository.TokenRepository;
import com.subscriptions.app.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;

    public String register(RegisterRequest request) {

        var user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .build();

        var savedUser = userRepository.save(user);

        return null;
    }

}
