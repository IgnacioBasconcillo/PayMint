package com.paymint.payment.model.valueobjects;

public record Currency(String code) {
  public Currency {
    if (!code.matches("^[A-Z]{3}$")) {
      throw new IllegalArgumentException(
          "Invalid currency code format. Must be three uppercase letters.");
    }
  }
}
