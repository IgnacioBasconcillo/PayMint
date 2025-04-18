package com.paymint.users.command;

import com.paymint.ConverterService;
import com.paymint.concepts.hexagonal.PrimaryAdapter;
import com.paymint.concepts.messaging.MessagePublisher;
import com.paymint.concepts.messaging.command.DomainCommandHandler;
import com.paymint.exceptions.PaymintException;
import com.paymint.users.messagelistener.PublishUser;
import com.paymint.users.models.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommandHandler implements DomainCommandHandler<CreateUserCommand>, PrimaryAdapter {
  private static final Logger LOGGER = LoggerFactory.getLogger(CreateUserCommandHandler.class);
  private final ConverterService converterService;

  public CreateUserCommandHandler(ConverterService converterService) {
    this.converterService = converterService;
  }

  @Override
  @Async
  @EventListener
  public void handle(CreateUserCommand command) {
    try {
      User user = converterService.convert("transactionId", command.userDTO());
      MessagePublisher.execute(new PublishUser(command.transactionId(), user));
    } catch (PaymintException e) {
      LOGGER.error("Error creating user: {}", e.getMessage());
      throw new RuntimeException("Error creating user", e);
    }
  }
}
