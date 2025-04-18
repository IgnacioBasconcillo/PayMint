package com.paymint.concepts.messaging.event;

public interface IntegrationEventListener<T extends IntegrationEvent> {
    void handle(T domainEvent);
}
