package com.paymint.user.model.valueobjects;

import java.util.UUID;

public record UserId(String value) {
  public UserId {
    try {
      UUID.fromString(value);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("UserId must be a valid UUID");
    }
  }

  public static UserId generate() {
    return new UserId(UUID.randomUUID().toString());
  }
}
