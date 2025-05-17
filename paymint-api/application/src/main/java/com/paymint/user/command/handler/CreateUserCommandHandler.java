package com.paymint.user.command.handler;

import com.paymint.user.converters.DTOToUserConverterPort;
import com.paymint.concepts.hexagonal.PrimaryAdapter;
import com.paymint.concepts.messaging.MessagePublisher;
import com.paymint.concepts.messaging.command.DomainCommandHandler;
import com.paymint.exceptions.PaymintException;
import com.paymint.user.command.model.CreateUserCommand;
import com.paymint.user.command.model.PublishUser;
import com.paymint.user.model.aggregates.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommandHandler
    implements DomainCommandHandler<CreateUserCommand>, PrimaryAdapter {
  private static final Logger LOGGER = LoggerFactory.getLogger(CreateUserCommandHandler.class);
  private final DTOToUserConverterPort DTOToUserConverterPort;

  public CreateUserCommandHandler(DTOToUserConverterPort DTOToUserConverterPort) {
    this.DTOToUserConverterPort = DTOToUserConverterPort;
  }

  @Override
  @Async
  @EventListener
  public void handle(CreateUserCommand command) {
    try {
      User user = DTOToUserConverterPort.convert(command.transactionId(), command.userDTO());
      MessagePublisher.execute(new PublishUser(command.transactionId(), user));
    } catch (PaymintException e) {
      LOGGER.error("Error creating user: {}", e.getMessage());
      throw new RuntimeException("Error creating user", e);
    }
  }
}
