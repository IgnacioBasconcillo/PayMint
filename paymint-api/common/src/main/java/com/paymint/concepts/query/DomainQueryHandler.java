package com.paymint.concepts.query;

import com.paymint.exceptions.PaymintException;

public interface DomainQueryHandler<Q,R> {
    R handle(Q query) throws PaymintException;
}
