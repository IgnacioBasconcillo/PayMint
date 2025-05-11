package com.paymint.users.query.handle;

import com.paymint.concepts.query.DomainQueryHandler;
import com.paymint.users.model.entities.User;
import com.paymint.users.ports.dao.UserDao;
import com.paymint.users.query.model.GetUserByIdQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetUserByIdQueryHandler
    implements DomainQueryHandler<GetUserByIdQuery, Optional<User>> {
  private static final Logger LOGGER = LoggerFactory.getLogger(GetUserByIdQueryHandler.class);
  private final UserDao userDao;

  public GetUserByIdQueryHandler(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public Optional<User> handle(GetUserByIdQuery getUserByIdQuery) {
    return userDao.getUserById(getUserByIdQuery.userId());
  }
}
