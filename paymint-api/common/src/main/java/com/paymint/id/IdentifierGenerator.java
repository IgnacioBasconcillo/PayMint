package com.paymint.id;

import com.paymint.concepts.ddd.Identifier;
import com.paymint.concepts.ddd.ValueObject;

import java.io.Serializable;
import java.util.UUID;

public final class IdentifierGenerator {

  private static final String FROM_STRING_DELIMITER = "|";

  private IdentifierGenerator() {}

  public static String nextId() {
    return nextString();
  }

  public static String nextString() {
    return java.util.UUID.randomUUID().toString();
  }

  public static String nextId(String... from) { return nextString(from);}

  public static String nextString(String... from) {
    return UUID.nameUUIDFromBytes(String.join(FROM_STRING_DELIMITER, from).getBytes()).toString();
  }
}
