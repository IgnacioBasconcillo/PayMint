package com.paymint.payment.model.valueobjects;

import java.time.LocalDateTime;
import java.util.Objects;

public record TimeStamp(LocalDateTime value) {
  public TimeStamp {
    Objects.requireNonNull(value);
  }
}
