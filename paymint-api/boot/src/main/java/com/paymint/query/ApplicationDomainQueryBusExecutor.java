package com.paymint.query;

import com.paymint.concepts.query.DomainQueryExecutor;
import com.paymint.concepts.query.QueryBus;
import com.paymint.exceptions.PaymintException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.management.Query;

@Component
public class ApplicationDomainQueryBusExecutor implements DomainQueryExecutor {
  private static final Logger LOGGER =
      LoggerFactory.getLogger(ApplicationDomainQueryBusExecutor.class);

  @Override
  public <R> R executeQuery(Query query) throws PaymintException {
    try {
      LOGGER.debug("Executing query: {}", query);
      return QueryBus.execute(query);
    } catch (Exception e) {
      LOGGER.error("Error executing query: {}", query, e);
      throw new PaymintException();
    }
  }
}
