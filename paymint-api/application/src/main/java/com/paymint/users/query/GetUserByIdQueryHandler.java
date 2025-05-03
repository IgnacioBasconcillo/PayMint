package com.paymint.users.query;

import com.paymint.concepts.query.DomainQueryHandler;
import com.paymint.users.models.entities.User;
import com.paymint.users.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetUserByIdQueryHandler
    implements DomainQueryHandler<GetUserByIdQuery, Optional<User>> {
  private static final Logger LOGGER = LoggerFactory.getLogger(GetUserByIdQueryHandler.class);
  private final UserRepository userRepository;

  public GetUserByIdQueryHandler(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Optional<User> handle(GetUserByIdQuery getUserByIdQuery) {
    return userRepository.getUserById(getUserByIdQuery.userId());
  }
}
