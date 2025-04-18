package com.paymint.concepts.messaging.command;

public interface DomainCommandHandler <T extends DomainCommand>{
    void handle(T command);
}
