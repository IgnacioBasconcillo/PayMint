package com.paymint.concepts.messaging.command;

public interface DomainCommandExecutor {
    void execute(DomainCommand command);
}
