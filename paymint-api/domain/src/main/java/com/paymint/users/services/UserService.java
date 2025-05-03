package com.paymint.users.services;

import com.paymint.users.models.entities.User;

import java.util.List;

public interface UserService {
  void createUser(User user);

  User updateUser(String id, User user);

  void deleteUser(String id);
}
