package com.paymint.user.model.valueobjects.merchant;

import java.util.Objects;
import java.util.UUID;

public record MerchantId(UUID value) {
  public MerchantId {
    Objects.requireNonNull(value);
  }

  public static MerchantId generate() {
    return new MerchantId(UUID.randomUUID());
  }
}
