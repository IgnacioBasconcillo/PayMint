package com.paymint.user.command.model;

import com.paymint.concepts.messaging.command.DomainCommand;
import com.paymint.user.model.aggregates.User;

public record PublishUser(String transactionId, User user) implements DomainCommand {}
