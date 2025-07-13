package com.paymint.refund.model.valueobjects;

import java.util.UUID;

public record RefundId(UUID value) {
  public RefundId {
    if (value == null) {
      throw new IllegalArgumentException("RefundId cannot be null");
    }
  }

  public static RefundId of(UUID value) {
    return new RefundId(value);
  }
}
