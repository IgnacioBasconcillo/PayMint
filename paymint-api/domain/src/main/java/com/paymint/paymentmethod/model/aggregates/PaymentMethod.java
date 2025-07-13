package com.paymint.paymentmethod.model.aggregates;

import com.paymint.paymentmethod.model.enums.PaymentMethodType;
import com.paymint.paymentmethod.model.valueobjects.PaymentMethodId;

public class PaymentMethod {
  private final PaymentMethodId id;
  private final PaymentMethodType paymentMethodType;

  public PaymentMethod(PaymentMethodId id, PaymentMethodType paymentMethodType) {
    this.id = id;
    this.paymentMethodType = paymentMethodType;
  }

  public PaymentMethodId getId() {
    return id;
  }

  public PaymentMethodType getType() {
    return paymentMethodType;
  }
}
