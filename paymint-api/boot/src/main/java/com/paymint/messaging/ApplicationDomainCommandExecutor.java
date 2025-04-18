package com.paymint.messaging;

import com.paymint.concepts.messaging.command.DomainCommand;
import com.paymint.concepts.messaging.command.DomainCommandExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ApplicationDomainCommandExecutor implements DomainCommandExecutor {
  private static final Logger LOGGER =
      LoggerFactory.getLogger(DomainCommandExecutor.class.getName());

  private final ApplicationEventPublisher applicationEventPublisher;

  public ApplicationDomainCommandExecutor(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @Override
    public void execute (DomainCommand command){
      applicationEventPublisher.publishEvent(command);
      LOGGER.debug("Command executed: {}", command);
  }
}
