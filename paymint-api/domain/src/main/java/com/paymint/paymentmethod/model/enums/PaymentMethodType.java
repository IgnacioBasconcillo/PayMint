package com.paymint.paymentmethod.model.enums;

import com.paymint.paymentmethod.exception.PaymentMethodTypeException;

import java.util.Arrays;

public enum PaymentMethodType {
  CREDIT_CARD("Credit Card"),
  BANK_TRANSFER("Bank Transfer"),
  PAYPAL("PayPal");

  private final String type;

  PaymentMethodType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public static PaymentMethodType fromString(String value) {
    if (value == null || value.trim().isEmpty()) {
      throw new PaymentMethodTypeException("Payment method type cannot be null or empty");
    }

    return Arrays.stream(PaymentMethodType.values())
        .filter(method -> method.getType().equalsIgnoreCase(value.trim()))
        .findFirst()
        .orElseThrow(() -> new PaymentMethodTypeException("Invalid payment method type: " + value));
  }
}
