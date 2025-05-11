package com.paymint.users.model.valueobjects;

public record NationalId(String value) {
    public NationalId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("National ID cannot be null or empty");
        }
    }
}
