package com.paymint.concepts.query;

public interface DomainQueryHandler<Q,R> {
    R handle(Q query);
}
