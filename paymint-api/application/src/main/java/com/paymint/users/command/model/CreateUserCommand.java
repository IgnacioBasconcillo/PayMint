package com.paymint.users.command.model;

import com.paymint.concepts.data.DTO;
import com.paymint.concepts.messaging.command.DomainCommand;

public record CreateUserCommand(String transactionId, DTO userDTO) implements DomainCommand {}
