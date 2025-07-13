package com.paymint.payment.model.valueobjects;

public record FailureReason(String value) {
    public FailureReason {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Failure reason cannot be null or blank");
        }
    }
}
