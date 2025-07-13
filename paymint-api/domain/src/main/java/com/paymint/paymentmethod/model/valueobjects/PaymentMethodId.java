package com.paymint.paymentmethod.model.valueobjects;

import com.paymint.id.Id;
import com.paymint.id.IdentifierGenerator;
import com.paymint.paymentmethod.exception.PaymentMethodIdException;

import java.util.UUID;

public record PaymentMethodId(UUID value) {

  public PaymentMethodId {
    if (value == null) {
      throw new PaymentMethodIdException("PaymentMethodId value cannot be null");
    }
  }

  public static Id generate() {
    return new Id(IdentifierGenerator.nextId());
  }
}
