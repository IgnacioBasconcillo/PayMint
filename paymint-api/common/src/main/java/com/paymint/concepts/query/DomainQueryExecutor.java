package com.paymint.concepts.query;

import com.paymint.exceptions.PaymintException;

import javax.management.Query;

public interface DomainQueryExecutor {
  <R> R executeQuery(Query query) throws PaymintException;
}
