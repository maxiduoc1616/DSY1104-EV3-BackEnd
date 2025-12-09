package com.example.backend.dto;

import java.util.List;

public class LoginResponse {
    private final String token;
    private final Long userId;
    private final String userName;
    private final List<String> roles;

    public LoginResponse(String token, Long userId, String userName, List<String> roles) {
        this.token = token;
        this.userId = userId;
        this.userName = userName;
        this.roles = roles;
    }

    public String getToken() { return token; }
    public Long getUserId() { return userId; }
    public String getUserName() { return userName; }
    public List<String> getRoles() { return roles; }
}