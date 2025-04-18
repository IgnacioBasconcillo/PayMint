package com.paymint.concepts.messaging.command;

public interface IntegrationCommandHandler<T extends IntegrationCommand> {
    void handle(T command);
}
