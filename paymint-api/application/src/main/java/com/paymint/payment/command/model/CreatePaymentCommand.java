package com.paymint.payment.command.model;

import com.paymint.concepts.data.DTO;
import com.paymint.concepts.messaging.command.DomainCommand;

public record CreatePaymentCommand(String transactionId, DTO paymentDTO) implements DomainCommand {}
