package com.paymint.payment.model.aggregates;

import com.paymint.payment.model.entities.Authorization;
import com.paymint.payment.model.entities.Transaction;
import com.paymint.payment.model.enums.PaymentStatus;
import com.paymint.payment.model.valueobjects.Money;
import com.paymint.payment.model.valueobjects.PaymentId;
import com.paymint.paymentmethod.model.valueobjects.PaymentMethodId;
import com.paymint.user.model.valueobjects.UserId;

import java.time.LocalDateTime;
import java.util.*;

public class Payment {

  private final PaymentId paymentId;
  private final UserId payerId;
  private final UserId recipientId;
  private final PaymentMethodId paymentMethodId;
  private final Money amount;
  private final LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private PaymentStatus status;
  private final List<Transaction> transactions;
  private Authorization authorization;

  private Payment(
      PaymentId paymentId,
      UserId payerId,
      UserId recipientId,
      PaymentMethodId paymentMethodId,
      Money amount,
      LocalDateTime createdAt) {

    if (payerId.equals(recipientId)) {
      throw new IllegalArgumentException("Payer and recipient cannot be the same.");
    }

    this.paymentId = Objects.requireNonNull(paymentId);
    this.payerId = Objects.requireNonNull(payerId);
    this.recipientId = Objects.requireNonNull(recipientId);
    this.paymentMethodId = Objects.requireNonNull(paymentMethodId);
    this.amount = Objects.requireNonNull(amount);
    this.createdAt = Objects.requireNonNull(createdAt);
    this.updatedAt = createdAt;
    this.status = PaymentStatus.CREATED;
    this.transactions = new ArrayList<>();
  }

  public static Payment create(
      PaymentId paymentId,
      UserId payerId,
      UserId recipientId,
      PaymentMethodId paymentMethodId,
      Money amount) {
    return new Payment(
        paymentId, payerId, recipientId, paymentMethodId, amount, LocalDateTime.now());
  }

  public void authorize(Authorization auth, String providedToken) {
    if (this.authorization != null) {
      throw new IllegalStateException("Authorization already exists.");
    }

    auth.authorize(providedToken);
    this.authorization = auth;
    this.updatedAt = LocalDateTime.now();
    this.status = PaymentStatus.AUTHORIZED;
  }

  public void complete() {
    if (status != PaymentStatus.CREATED && status != PaymentStatus.AUTHORIZED) {
      throw new IllegalStateException("Payment must be CREATED or AUTHORIZED.");
    }

    if (authorization != null && !authorization.isAuthorized()) {
      throw new IllegalStateException("Payment not authorized.");
    }

    this.transactions.add(Transaction.debit(this.amount));
    this.transactions.add(Transaction.credit(this.amount));

    this.status = PaymentStatus.COMPLETED;
    this.updatedAt = LocalDateTime.now();
  }

  public void fail(String reason) {
    if (!List.of(PaymentStatus.CREATED, PaymentStatus.AUTHORIZED).contains(this.status)) {
      throw new IllegalStateException("Cannot fail a finalized payment.");
    }

    this.status = PaymentStatus.FAILED;
    this.updatedAt = LocalDateTime.now();
  }

  public PaymentId paymentId() {
    return paymentId;
  }

  public PaymentStatus status() {
    return status;
  }

  public List<Transaction> transactions() {
    return List.copyOf(transactions);
  }

  public Authorization authorization() {
    return authorization;
  }

  public Money amount() {
    return amount;
  }

  public PaymentMethodId paymentMethodId() {
    return paymentMethodId;
  }

  public UserId payerId() {
    return payerId;
  }

  public UserId recipientId() {
    return recipientId;
  }
}
