package com.paymint.payment.model.valueobjects.transaction;

import java.util.Objects;
import java.util.UUID;

public record TransactionId(UUID value) {

  public TransactionId {
    Objects.requireNonNull(value, "TransactionId value cannot be null");
  }

  public static TransactionId generate() {
    return new TransactionId(UUID.randomUUID());
  }

  @Override
  public String toString() {
    return value.toString();
  }
}
