package com.paymint.models.valueobjects;

public record Name(String value) {
    public Name {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (value.length() > 100) {
            throw new IllegalArgumentException("Name must not exceed 100 characters");
        }
    }
}
