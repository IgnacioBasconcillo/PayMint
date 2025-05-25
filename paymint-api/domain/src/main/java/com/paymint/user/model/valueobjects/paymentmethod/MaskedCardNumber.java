package com.paymint.user.model.valueobjects.paymentmethod;

import java.util.Objects;

public record MaskedCardNumber(String value) {

  public MaskedCardNumber {
    Objects.requireNonNull(value);
    if (!value.matches("^\\*{12}\\d{4}$")) {
      throw new IllegalArgumentException(
          "Invalid masked card number format. Expected format: **** **** **** 1234");
    }
  }
}
