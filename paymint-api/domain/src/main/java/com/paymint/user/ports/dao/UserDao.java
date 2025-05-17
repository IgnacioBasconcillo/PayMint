package com.paymint.user.ports.dao;

import com.paymint.user.model.aggregates.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
  public List<User> getAllUsers();

  public Optional<User> getUserByEmail(String email);
}
