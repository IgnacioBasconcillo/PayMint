package com.paymint.concepts.messaging.event;

public interface DomainEventListener<T extends DomainEvent>{
    void handle(T domainEvent);
}
