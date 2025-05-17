package com.paymint.user.ports.repositories;

import com.paymint.user.model.aggregates.User;

public interface UserRepository {
  public void createUser(User user);
}
