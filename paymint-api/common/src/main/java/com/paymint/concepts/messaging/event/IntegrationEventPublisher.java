package com.paymint.concepts.messaging.event;

public interface IntegrationEventPublisher {
    void publish(IntegrationEvent integrationEvent);
}
