package com.paymint.merchant.model.valueobjects;

import com.paymint.merchant.exception.MerchantIdException;

import java.util.UUID;

public record MerchantId(UUID value) {
  public MerchantId {
    if (value == null) {
      throw new MerchantIdException("MerchantId cannot be null");
    }
    if (value.toString().isEmpty()) {
      throw new MerchantIdException("MerchantId cannot be empty");
    }
  }

  public static MerchantId generate() {
    return new MerchantId(UUID.randomUUID());
  }
}
