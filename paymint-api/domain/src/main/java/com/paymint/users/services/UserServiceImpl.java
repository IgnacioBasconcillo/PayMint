package com.paymint.users.services;

import com.paymint.users.model.entities.User;
import com.paymint.users.ports.repositories.UserRepository;

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
