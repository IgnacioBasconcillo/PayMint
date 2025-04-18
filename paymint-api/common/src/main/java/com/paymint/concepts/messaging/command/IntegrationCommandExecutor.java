package com.paymint.concepts.messaging.command;

import com.paymint.exceptions.PaymintException;

public interface IntegrationCommandExecutor {
  void execute(IntegrationCommand command);

  <C extends IntegrationCommand, R extends IntegrationCommand> R executeAndReceive(
      C command, Class<R> responseClass) throws PaymintException;
}
