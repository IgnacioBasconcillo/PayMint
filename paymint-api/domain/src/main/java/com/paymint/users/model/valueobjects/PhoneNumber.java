package com.paymint.users.model.valueobjects;

public record PhoneNumber(String value) {
    public PhoneNumber {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("PhoneNumber cannot be null or empty");
        }
        if (!value.matches("\\+?[0-9]{10,15}")) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
    }
}
