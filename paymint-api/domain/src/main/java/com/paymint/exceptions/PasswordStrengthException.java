package com.paymint.exceptions;

public class PasswordStrengthException extends RuntimeException {
    public PasswordStrengthException(String message) {
        super(message);
    }
}
