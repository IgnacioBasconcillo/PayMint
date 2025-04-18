package com.paymint.users.messagelistener;

import com.paymint.concepts.messaging.command.DomainCommand;
import com.paymint.users.models.entities.User;

public record PublishUser(String transactionId, User user) implements DomainCommand {}
