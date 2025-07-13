package com.paymint.merchant.model.valueobjects;

import com.paymint.merchant.exception.ApiKeyException;

import java.time.Instant;

public record ApiKey(String value, Instant createdAt, Instant expiresAt, MerchantId merchantId) {

  public ApiKey {
    if (value == null || value.isBlank()) {
      throw new ApiKeyException("API key value cannot be null or blank");
    }
    if (createdAt == null || expiresAt == null) {
      throw new ApiKeyException("Timestamps cannot be null");
    }
    if (expiresAt.isBefore(createdAt)) {
      throw new ApiKeyException("Expiration date must be after creation date");
    }
    if (merchantId == null) {
      throw new ApiKeyException("Merchant ID cannot be null or blank");
    }
  }

  public boolean isExpired() {
    return Instant.now().isAfter(expiresAt);
  }

  public boolean isValid() {
    return !isExpired();
  }
}
