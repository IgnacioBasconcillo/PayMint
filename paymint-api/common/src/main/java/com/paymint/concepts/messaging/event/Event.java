package com.paymint.concepts.messaging.event;

import java.io.Serializable;
import java.time.Instant;

public interface Event extends Serializable {
  default String eventId() {
    return null;
  }

  default Instant occuredOn() {
    return Instant.now();
  }
}
