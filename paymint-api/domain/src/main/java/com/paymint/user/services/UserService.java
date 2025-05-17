package com.paymint.user.services;

import com.paymint.user.model.aggregates.User;

public interface UserService {
  void createUser(User user);

  User updateUser(String id, User user);

  void deleteUser(String id);
}
