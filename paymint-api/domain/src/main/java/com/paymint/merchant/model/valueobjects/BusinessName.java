package com.paymint.merchant.model.valueobjects;

import com.paymint.merchant.exception.BusinessNameException;

public record BusinessName(String name) {
  public BusinessName {
    if (name == null || name.isBlank()) {
      throw new BusinessNameException("Business name cannot be null or blank");
    }
    if (name.length() > 100) {
      throw new BusinessNameException("Business name cannot exceed 100 characters");
    }
  }

  @Override
  public String toString() {
    return "BusinessName{" + "name='" + name + '\'' + '}';
  }
}
