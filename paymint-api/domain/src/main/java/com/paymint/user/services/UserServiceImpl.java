package com.paymint.user.services;

import com.paymint.user.model.aggregates.User;
import com.paymint.user.ports.repositories.UserRepository;

public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void createUser(User user) {
    userRepository.createUser(user);
  }

  @Override
  public User updateUser(String id, User user) {
    return null;
  }

  @Override
  public void deleteUser(String id) {}
}
