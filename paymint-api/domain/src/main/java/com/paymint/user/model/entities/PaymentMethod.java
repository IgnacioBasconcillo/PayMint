package com.paymint.user.model.entities;

import com.paymint.user.model.enums.paymentmethod.PaymentMethodStatus;
import com.paymint.user.model.enums.paymentmethod.PaymentMethodType;
import com.paymint.user.model.valueobjects.paymentmethod.ExpiryDate;
import com.paymint.user.model.valueobjects.paymentmethod.MaskedCardNumber;
import com.paymint.user.model.valueobjects.paymentmethod.PaymentMethodId;

import java.util.Objects;

public class PaymentMethod {

  private final PaymentMethodId methodId;
  private final PaymentMethodType type;
  private final MaskedCardNumber maskedCardNumber;
  private final String token;
  private final ExpiryDate expiryDate;
  private PaymentMethodStatus status;

  public PaymentMethod(
      PaymentMethodId methodId,
      PaymentMethodType type,
      MaskedCardNumber maskedCardNumber,
      String token,
      ExpiryDate expiryDate) {
    this.methodId = Objects.requireNonNull(methodId);
    this.type = Objects.requireNonNull(type);
    this.maskedCardNumber = Objects.requireNonNull(maskedCardNumber);
    this.token = Objects.requireNonNull(token);
    this.expiryDate = Objects.requireNonNull(expiryDate);
    this.status = PaymentMethodStatus.ACTIVE;
  }

  public boolean isActive() {
    return status == PaymentMethodStatus.ACTIVE && !expiryDate.isExpired();
  }

  public void deactivate() {
    this.status = PaymentMethodStatus.INACTIVE;
  }

  public void reactivate() {
    if (!expiryDate.isExpired()) {
      this.status = PaymentMethodStatus.ACTIVE;
    }
  }

  public PaymentMethodId getMethodId() {
    return methodId;
  }

  public PaymentMethodType getType() {
    return type;
  }

  public MaskedCardNumber getMaskedCardNumber() {
    return maskedCardNumber;
  }

  public String getToken() {
    return token;
  }

  public ExpiryDate getExpiryDate() {
    return expiryDate;
  }

  public PaymentMethodStatus getStatus() {
    return status;
  }
}
