package com.paymint.messaging;

import com.paymint.concepts.messaging.MessagePublisher;
import com.paymint.concepts.messaging.command.DomainCommandExecutor;
import com.paymint.concepts.messaging.command.IntegrationCommandExecutor;
import com.paymint.concepts.messaging.event.DomainEventPublisher;
import com.paymint.concepts.messaging.event.IntegrationEventPublisher;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class EventPublisherInitializer {
  private final DomainEventPublisher domainEventPublisher;
  private final DomainCommandExecutor domainCommandExecutor;
  private final IntegrationEventPublisher integrationEventPublisher;
  private final IntegrationCommandExecutor integrationCommandExecutor;

  public EventPublisherInitializer(
      DomainEventPublisher domainEventPublisher,
      DomainCommandExecutor domainCommandExecutor,
      IntegrationEventPublisher integrationEventPublisher,
      IntegrationCommandExecutor integrationCommandExecutor) {
    this.domainEventPublisher = domainEventPublisher;
    this.domainCommandExecutor = domainCommandExecutor;
    this.integrationEventPublisher = integrationEventPublisher;
    this.integrationCommandExecutor = integrationCommandExecutor;
  }

  @PostConstruct
  void init() {
    MessagePublisher.init(
        domainEventPublisher,
        domainCommandExecutor,
        integrationEventPublisher,
        integrationCommandExecutor);
  }
}
