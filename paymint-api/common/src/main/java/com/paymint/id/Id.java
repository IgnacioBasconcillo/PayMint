package com.paymint.id;

import com.paymint.concepts.ddd.Identifier;
import com.paymint.concepts.ddd.ValueObject;

import java.io.Serializable;
import java.util.Objects;

public class Id implements Identifier, ValueObject, Serializable {
  static final Id EMPTY = new Id("");
  private final String value;

  public Id(String value) {
    this.value = value;
  }

  public static Id of(String value) {
    if (value == null || value.isEmpty()) {
      throw new IllegalArgumentException("Id cannot be null or empty");
    }
    return new Id(value);
  }

  public static Id next() {
    return new Id(IdentifierGenerator.nextId());
  }

  public static Id from(String... from) {
    return new Id(IdentifierGenerator.nextId(from));
  }

  public String value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Id id = (Id) o;

    return Objects.equals(value, id.value);
  }

  @Override
  public int hashCode() {
    return value != null ? value.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Id{" + "value='" + value + '\'' + '}';
  }
}
