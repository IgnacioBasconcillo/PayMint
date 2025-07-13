package com.paymint.payment.model.valueobjects;

import java.util.Objects;
import java.util.UUID;

public record PaymentId(UUID value) {
  public PaymentId {
    Objects.requireNonNull(value);
  }
}
