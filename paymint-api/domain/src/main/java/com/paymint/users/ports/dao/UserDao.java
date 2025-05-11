package com.paymint.users.ports.dao;

import com.paymint.users.model.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
  public List<User> getAllUsers();

  public Optional<User> getUserById(String id);
}
