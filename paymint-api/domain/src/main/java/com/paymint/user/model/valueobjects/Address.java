package com.paymint.user.model.valueobjects;

public record Address(String street, String city, String postalCode, String country) {
  public Address {
    if (street == null
        || street.isBlank()
        || city == null
        || city.isBlank()
        || postalCode == null
        || postalCode.isBlank()
        || country == null
        || country.isBlank()) {
      throw new IllegalArgumentException("All address fields must be provided");
    }
  }
}
