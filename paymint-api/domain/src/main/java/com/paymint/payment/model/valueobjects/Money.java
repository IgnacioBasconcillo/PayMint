package com.paymint.payment.model.valueobjects;

import java.math.BigDecimal;

import java.math.BigDecimal;
import java.util.Objects;

public record Money(BigDecimal amount, Currency currency) {

  public Money {
    Objects.requireNonNull(amount, "Amount cannot be null");
    Objects.requireNonNull(currency, "Currency cannot be null");
    if (amount.compareTo(BigDecimal.ZERO) < 0)
      throw new IllegalArgumentException("Amount must be non-negative");
  }

  public static Money zero(Currency currency) {
    return new Money(BigDecimal.ZERO, currency);
  }

  public Money add(Money other) {
    checkCurrencyMatch(other);
    return new Money(this.amount.add(other.amount), this.currency);
  }

  public Money subtract(Money other) {
    checkCurrencyMatch(other);
    BigDecimal result = this.amount.subtract(other.amount);
    if (result.compareTo(BigDecimal.ZERO) < 0)
      throw new IllegalArgumentException("Resulting amount cannot be negative");
    return new Money(result, this.currency);
  }

  public boolean isGreaterThan(Money other) {
    checkCurrencyMatch(other);
    return this.amount.compareTo(other.amount) > 0;
  }

  public boolean isNegative() {
    return this.amount.compareTo(BigDecimal.ZERO) < 0;
  }

  private void checkCurrencyMatch(Money other) {
    if (!this.currency.equals(other.currency)) {
      throw new IllegalArgumentException("Currencies must match");
    }
  }
}
