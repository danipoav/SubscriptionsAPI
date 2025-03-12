package com.subscriptions.app.service;

import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final String SECRET_KEY = "new_secret_key";
    private final long EXPIRATION_TIME = 86400000;
    private final long REFRESH_TOKEN = 604800000;

    public String generateToken() {
        return null;
    }

}
