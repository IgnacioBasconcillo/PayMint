package com.paymint.users.exceptions;

public class PasswordStrengthException extends RuntimeException {
    public PasswordStrengthException(String message) {
        super(message);
    }
}
