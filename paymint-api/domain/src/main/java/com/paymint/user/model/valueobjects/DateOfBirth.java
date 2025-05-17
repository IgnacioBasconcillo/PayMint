package com.paymint.user.model.valueobjects;

import java.time.LocalDate;

public record DateOfBirth(LocalDate value) {
  public DateOfBirth {
    if (value.isAfter(LocalDate.now().minusYears(18))) {
      throw new IllegalArgumentException("User must be at least 18 years old");
    }
  }
}
