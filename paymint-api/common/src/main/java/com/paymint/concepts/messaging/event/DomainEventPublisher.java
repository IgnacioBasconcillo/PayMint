package com.paymint.concepts.messaging.event;

public interface DomainEventPublisher {
    void publish(DomainEvent domainEvent);
}
