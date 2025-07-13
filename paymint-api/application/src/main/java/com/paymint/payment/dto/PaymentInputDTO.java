package com.paymint.payment.dto;

import com.paymint.concepts.data.DTO;

public class PaymentInputDTO implements DTO {
    private String paymentId;
    private String amount;
    private String currency;
    private String paymentMethod;

    public PaymentInputDTO() {
    }

    public PaymentInputDTO(String paymentId, String amount, String currency, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.currency = currency;
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
