package com.paymint.models.valueobjects;

public record AccountStatus(String value) {
    public AccountStatus {
        if (!value.matches("ACTIVE|SUSPENDED|CLOSED")) {
            throw new IllegalArgumentException("Invalid account status");
        }
    }
}

