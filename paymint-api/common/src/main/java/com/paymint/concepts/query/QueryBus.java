package com.paymint.concepts.query;

import com.paymint.exceptions.PaymintException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class QueryBus {
  private static final Map<Class<?>, DomainQueryHandler<?, ?>> handlers = new HashMap<>();

  public QueryBus(List<DomainQueryHandler<?, ?>> handlerList) {
    for (DomainQueryHandler<?, ?> handler : handlerList) {
      Class<?> queryType = getQueryType(handler);
      handlers.put(queryType, handler);
    }
  }

  @SuppressWarnings("unchecked")
  public static <Q, R> R execute(Q query) throws PaymintException {
    DomainQueryHandler<Q, R> handler = (DomainQueryHandler<Q, R>) handlers.get(query.getClass());
    if (handler == null) {
      throw new RuntimeException("No handler found for query: " + query.getClass().getName());
    }
    return handler.handle(query);
  }

  private static Class<?> getQueryType(DomainQueryHandler<?, ?> handler) {
    Type[] genericInterfaces = handler.getClass().getGenericInterfaces();
    for (Type type : genericInterfaces) {
      if (type instanceof ParameterizedType pt) {
        if (pt.getRawType().equals(DomainQueryHandler.class)) {
          Type actualType = pt.getActualTypeArguments()[0];
          return (Class<?>) actualType;
        }
      }
    }
    throw new RuntimeException(
        "Could not determine query type for handler: " + handler.getClass().getName());
  }
}
