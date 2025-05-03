package com.paymint.configuration;

import com.paymint.concepts.query.DomainQueryHandler;
import com.paymint.concepts.query.QueryBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QueryBusConfig {

  @Bean
  public QueryBus queryBus(List<DomainQueryHandler<?, ?>> handlerList) {
    return new QueryBus(handlerList);
  }
}
