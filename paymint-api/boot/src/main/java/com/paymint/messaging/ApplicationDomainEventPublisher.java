package com.paymint.messaging;

import com.paymint.concepts.messaging.event.DomainEvent;
import com.paymint.concepts.messaging.event.DomainEventPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ApplicationDomainEventPublisher implements DomainEventPublisher {
    private static final Logger LOGGER = LoggerFactory.getLogger(DomainEventPublisher.class.getName());

    private final ApplicationEventPublisher applicationEventPublisher;

    public ApplicationDomainEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void publish(final DomainEvent domainEvent){
        applicationEventPublisher.publishEvent(domainEvent);
        LOGGER.debug("Domain event published: {}", domainEvent);
    }
}
