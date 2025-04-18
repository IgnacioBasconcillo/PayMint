package com.paymint.concepts.messaging.event;

public interface IntegrationEvent extends Event {
  default String topic() {
    return this.getClass().getSimpleName();
  }

  default String key() {
    return null;
  }
}
