package com.paymint.concepts.messaging.command;

import java.time.Instant;

public interface Command {
    default Instant occuredAt() {
        return Instant.now();
    }
}
