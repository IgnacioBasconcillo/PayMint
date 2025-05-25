package com.paymint.user.model.valueobjects.paymentmethod;

import java.util.Objects;
import java.util.UUID;

public record PaymentMethodId(UUID value) {
  public PaymentMethodId {
    Objects.requireNonNull(value);
  }

  public static PaymentMethodId generate() {
    return new PaymentMethodId(UUID.randomUUID());
  }
}
