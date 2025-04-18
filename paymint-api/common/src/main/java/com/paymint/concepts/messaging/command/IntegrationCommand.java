package com.paymint.concepts.messaging.command;

import java.util.Collections;
import java.util.Map;

public interface IntegrationCommand extends Command {
  default String topic() {
    return this.getClass().getSimpleName();
  }

  default String key() {
    return null;
  }

  default Map<String, String> headers() {
    return Collections.emptyMap();
  }
}
