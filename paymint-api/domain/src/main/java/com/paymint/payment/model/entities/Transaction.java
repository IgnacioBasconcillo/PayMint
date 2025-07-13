package com.paymint.payment.model.entities;

import com.paymint.payment.model.enums.transaction.TransactionType;
import com.paymint.payment.model.valueobjects.Money;
import com.paymint.payment.model.valueobjects.transaction.TransactionId;

import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {

  private final TransactionId transactionId;
  private final TransactionType type;
  private final Money amount;
  private final LocalDateTime timestamp;
  private final String note;

  private Transaction(
      TransactionId transactionId,
      TransactionType type,
      Money amount,
      LocalDateTime timestamp,
      String note) {
    if (amount.isNegative()) {
      throw new IllegalArgumentException("Transaction amount must be non-negative");
    }

    this.transactionId = Objects.requireNonNull(transactionId);
    this.type = Objects.requireNonNull(type);
    this.amount = Objects.requireNonNull(amount);
    this.timestamp = Objects.requireNonNull(timestamp);
    this.note = note;
  }

  public static Transaction debit(Money amount) {
    return new Transaction(
        TransactionId.generate(), TransactionType.DEBIT, amount, LocalDateTime.now(), null);
  }

  public static Transaction credit(Money amount) {
    return new Transaction(
        TransactionId.generate(), TransactionType.CREDIT, amount, LocalDateTime.now(), null);
  }

  public static Transaction fee(Money amount, String note) {
    return new Transaction(
        TransactionId.generate(), TransactionType.FEE, amount, LocalDateTime.now(), note);
  }

  public static Transaction refund(Money amount, String reason) {
    return new Transaction(
        TransactionId.generate(), TransactionType.REFUND, amount, LocalDateTime.now(), reason);
  }

  public TransactionId transactionId() {
    return transactionId;
  }

  public TransactionType type() {
    return type;
  }

  public Money amount() {
    return amount;
  }

  public LocalDateTime timestamp() {
    return timestamp;
  }

  public String note() {
    return note;
  }

  public boolean isRefund() {
    return this.type == TransactionType.REFUND;
  }
}
