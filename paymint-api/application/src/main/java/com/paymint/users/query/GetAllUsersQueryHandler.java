package com.paymint.users.query;

import com.paymint.concepts.query.DomainQueryHandler;
import com.paymint.users.models.entities.User;
import com.paymint.users.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllUsersQueryHandler implements DomainQueryHandler<GetAllUsersQuery, List<User>> {
  private static final Logger LOGGER = LoggerFactory.getLogger(GetAllUsersQueryHandler.class);

  private final UserRepository userRepository;

  public GetAllUsersQueryHandler(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> handle(GetAllUsersQuery getAllUsersQuery) {
    return userRepository.getAllUsers();
  }
}
