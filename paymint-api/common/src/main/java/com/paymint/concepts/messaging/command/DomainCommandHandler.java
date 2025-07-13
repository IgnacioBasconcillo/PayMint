package com.paymint.concepts.messaging.command;

import com.paymint.exceptions.PaymintException;

public interface DomainCommandHandler <T extends DomainCommand>{
    void handle(T command) throws PaymintException;
}
