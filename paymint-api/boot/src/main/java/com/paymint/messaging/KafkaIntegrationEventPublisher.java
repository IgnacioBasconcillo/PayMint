package com.paymint.messaging;

import com.paymint.concepts.messaging.event.IntegrationEvent;
import com.paymint.concepts.messaging.event.IntegrationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class KafkaIntegrationEventPublisher implements IntegrationEventPublisher {

    @Override
    public void publish(final IntegrationEvent event){}
}
