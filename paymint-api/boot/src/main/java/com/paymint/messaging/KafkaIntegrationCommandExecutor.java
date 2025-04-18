package com.paymint.messaging;

import com.paymint.concepts.messaging.command.IntegrationCommand;
import com.paymint.concepts.messaging.command.IntegrationCommandExecutor;
import org.springframework.stereotype.Component;

@Component
public class KafkaIntegrationCommandExecutor implements IntegrationCommandExecutor {

  @Override
  public void execute(IntegrationCommand command) {}

  @Override
  public <C extends IntegrationCommand, R extends IntegrationCommand> R executeAndReceive(
      C command, Class<R> responseClass) {
    return null;
  }
}
