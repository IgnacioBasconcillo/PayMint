package com.paymint.models.valueobjects;

public record Role(String value) {
    public Role {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Role cannot be null or empty");
        }
        if (!value.matches("ADMIN|CUSTOMER|MERCHANT")) {
            throw new IllegalArgumentException("Invalid role value");
        }
    }
}
