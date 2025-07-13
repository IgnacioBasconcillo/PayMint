package com.paymint.refund.model.aggregates;

import com.paymint.payment.model.valueobjects.Money;
import com.paymint.payment.model.valueobjects.PaymentId;
import com.paymint.refund.model.enums.RefundStatus;
import com.paymint.refund.model.valueobjects.RefundId;

import java.time.LocalDateTime;

public class Refund {
  private final RefundId refundId;
  private final PaymentId paymentId;
  private final Money amount;
  private final String reason;
  private RefundStatus status;
  private final LocalDateTime createdAt;
  private LocalDateTime refundedAt;

  public Refund(RefundId refundId, PaymentId paymentId, Money amount, String reason) {
    this.refundId = refundId;
    this.paymentId = paymentId;
    this.amount = amount;
    this.reason = reason;
    this.status = RefundStatus.CREATED;
    this.createdAt = LocalDateTime.now();
  }

  public void approve() {
    if (!status.equals(RefundStatus.CREATED)) {
      throw new IllegalStateException("Just refunds in CREATED state can be approved");
    }
    this.status = RefundStatus.APPROVED;
  }

  public void reject(String reason) {
    if (status == RefundStatus.REFUNDED) {
      throw new IllegalStateException("It is not possible to reject a refunded refund");
    }
    this.status = RefundStatus.REJECTED;
  }

  public void complete() {
    if (!status.equals(RefundStatus.APPROVED)) {
      throw new IllegalStateException("Just refunds in APPROVED state can be completed");
    }
    this.status = RefundStatus.REFUNDED;
    this.refundedAt = LocalDateTime.now();
    // domainEvents.add(new RefundCompletedDomainEvent(...));
  }

  public RefundId getRefundId() {
    return refundId;
  }

  public PaymentId getPaymentId() {
    return paymentId;
  }

  public Money getAmount() {
    return amount;
  }

  public String getReason() {
    return reason;
  }

  public RefundStatus getStatus() {
    return status;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getRefundedAt() {
    return refundedAt;
  }
}
