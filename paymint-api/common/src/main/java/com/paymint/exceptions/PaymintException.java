package com.paymint.exceptions;

public class PaymintException extends Exception {
  public PaymintException() {}

  public PaymintException(String message) {
    super(message);
  }

  public PaymintException(String message, Throwable cause) {
    super(message, cause);
  }

  public PaymintException(Throwable cause) {
    super(cause);
  }

  public PaymintException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
