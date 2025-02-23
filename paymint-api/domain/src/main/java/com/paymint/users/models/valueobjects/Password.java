package com.paymint.users.models.valueobjects;

public record Password(String hashedValue) {
    public Password {
        if (hashedValue == null || hashedValue.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
    }

    public static Password fromPlainText(String plainPassword) {
        if (plainPassword == null || plainPassword.length() < 8) {
            throw new IllegalArgumentException("Password must have at least 8 characters");
        }
        // Aquí iría el algoritmo de hashing, como BCrypt
        String hashed = hashPassword(plainPassword);
        return new Password(hashed);
    }

    private static String hashPassword(String plainPassword) {
        // Ejemplo ficticio de hashing
        return Integer.toHexString(plainPassword.hashCode());
    }
}
