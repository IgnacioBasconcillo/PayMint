package com.paymint.users.services;

import com.paymint.users.model.entities.User;

public interface UserService {
  void createUser(User user);

  User updateUser(String id, User user);

  void deleteUser(String id);
}
