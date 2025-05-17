package com.paymint.user.exception;

public class PasswordStrengthException extends RuntimeException {
    public PasswordStrengthException(String message) {
        super(message);
    }
}
