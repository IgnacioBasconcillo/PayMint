package com.paymint.users.command.model;

import com.paymint.concepts.messaging.command.DomainCommand;
import com.paymint.users.model.entities.User;

public record PublishUser(String transactionId, User user) implements DomainCommand {}
