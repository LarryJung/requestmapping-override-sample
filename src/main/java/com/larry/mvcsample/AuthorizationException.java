package com.larry.mvcsample;

public class AuthorizationException extends RuntimeException {

    private String role;

    public AuthorizationException(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
