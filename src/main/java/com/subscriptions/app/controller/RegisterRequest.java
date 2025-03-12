package com.subscriptions.app.controller;

public record RegisterRequest(
        String email,
        String password,
        String name) {

}
