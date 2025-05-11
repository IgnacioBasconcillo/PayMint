package com.paymint.users.ports.repositories;

import com.paymint.users.model.entities.User;

public interface UserRepository {
  public void createUser(User user);
}
