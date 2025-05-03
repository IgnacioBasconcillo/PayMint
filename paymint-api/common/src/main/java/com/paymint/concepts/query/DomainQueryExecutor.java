package com.paymint.concepts.query;

import javax.management.Query;

public interface DomainQueryExecutor {
  <R> R executeQuery(Query query);
}
