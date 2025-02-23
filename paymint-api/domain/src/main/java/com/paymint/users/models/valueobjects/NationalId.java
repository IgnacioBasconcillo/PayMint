package com.paymint.users.models.valueobjects;

public record NationalId(String value) {
    public NationalId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("National ID cannot be null or empty");
        }
    }
}
