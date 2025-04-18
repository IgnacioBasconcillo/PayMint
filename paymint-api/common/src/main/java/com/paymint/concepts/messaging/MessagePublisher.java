package com.paymint.concepts.messaging;

import com.paymint.concepts.messaging.command.DomainCommand;
import com.paymint.concepts.messaging.command.DomainCommandExecutor;
import com.paymint.concepts.messaging.command.IntegrationCommand;
import com.paymint.concepts.messaging.command.IntegrationCommandExecutor;
import com.paymint.concepts.messaging.event.DomainEvent;
import com.paymint.concepts.messaging.event.DomainEventPublisher;
import com.paymint.concepts.messaging.event.IntegrationEvent;
import com.paymint.concepts.messaging.event.IntegrationEventPublisher;
import com.paymint.exceptions.PaymintException;

import java.util.Objects;

public final class MessagePublisher {

  private static DomainEventPublisher domainEventPublisher;
  private static DomainCommandExecutor domainCommandExecutor;
  private static IntegrationEventPublisher integrationEventPublisher;
  private static IntegrationCommandExecutor integrationCommandExecutor;

  public static void init(
      DomainEventPublisher domainEventPublisher,
      DomainCommandExecutor domainCommandExecutor,
      IntegrationEventPublisher integrationEventPublisher,
      IntegrationCommandExecutor integrationCommandExecutor) {
    MessagePublisher.domainEventPublisher = domainEventPublisher;
    MessagePublisher.domainCommandExecutor = domainCommandExecutor;
    MessagePublisher.integrationEventPublisher = integrationEventPublisher;
    MessagePublisher.integrationCommandExecutor = integrationCommandExecutor;
  }

  private MessagePublisher() {}

  public static void publish(DomainEvent event) {
    Objects.requireNonNull(event, "Event cannot be null");
    domainEventPublisher.publish(event);
  }

  public static void publish(IntegrationEvent event) {
    Objects.requireNonNull(event, "Event cannot be null");
    integrationEventPublisher.publish(event);
  }

  public static void execute(DomainCommand command) {
    Objects.requireNonNull(command, "Command cannot be null");
    domainCommandExecutor.execute(command);
  }

  public static void execute(IntegrationCommand command) {
    Objects.requireNonNull(command, "Command cannot be null");
    integrationCommandExecutor.execute(command);
  }

  public static <C extends IntegrationCommand, R extends IntegrationCommand> R executeandReceive(
      C command, Class<R> responseClass) throws PaymintException {
    Objects.requireNonNull(command, "Command cannot be null");
    return integrationCommandExecutor.executeAndReceive(command, responseClass);
  }
}
