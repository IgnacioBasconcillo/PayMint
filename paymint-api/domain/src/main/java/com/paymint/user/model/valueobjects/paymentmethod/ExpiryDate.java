package com.paymint.user.model.valueobjects.paymentmethod;

import java.time.YearMonth;
import java.util.Objects;

public record ExpiryDate(YearMonth value) {

  public ExpiryDate {
    Objects.requireNonNull(value);
  }

  public boolean isExpired() {
    return value.isBefore(YearMonth.now());
  }
}
