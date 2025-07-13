package com.paymint.payment.command.model;

import com.paymint.concepts.messaging.command.DomainCommand;
import com.paymint.payment.model.aggregates.Payment;

public record PublishPaymentCommand(String transactionId, Payment payment) implements DomainCommand {}
