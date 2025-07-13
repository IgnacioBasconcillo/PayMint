package com.paymint.payment.command.handler;

import com.paymint.concepts.hexagonal.PrimaryAdapter;
import com.paymint.concepts.messaging.MessagePublisher;
import com.paymint.concepts.messaging.command.DomainCommandHandler;
import com.paymint.exceptions.PaymintException;
import com.paymint.payment.command.model.CreatePaymentCommand;
import com.paymint.payment.command.model.PublishPaymentCommand;
import com.paymint.payment.converters.DTOToPaymentConverterPort;
import com.paymint.payment.model.aggregates.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CreatePaymentCommandHandler implements DomainCommandHandler<CreatePaymentCommand>, PrimaryAdapter {
  private static final Logger LOGGER = LoggerFactory.getLogger(CreatePaymentCommandHandler.class);
  private final DTOToPaymentConverterPort dtoToPaymentConverterPort;

  public CreatePaymentCommandHandler(DTOToPaymentConverterPort dtoToPaymentConverterPort) {
    this.dtoToPaymentConverterPort = dtoToPaymentConverterPort;
  }

  @Override
  @Async
  @EventListener
  public void handle(CreatePaymentCommand command) throws PaymintException {
    try {
      Payment payment =
          dtoToPaymentConverterPort.convert(command.transactionId(), command.paymentDTO());
     /* MessagePublisher.execute(new PublishPaymentCommand(command.transactionId(), payment));*/
    } catch (Exception e) {
      LOGGER.error("Error creating payment: {}", e.getMessage());
      throw new PaymintException("Error creating payment", e);
    }
  }
}
