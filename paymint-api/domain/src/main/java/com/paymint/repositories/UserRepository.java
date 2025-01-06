package com.paymint.repositories;

import com.paymint.models.entities.User;

import java.util.List;

public interface UserRepository {
    public void createUser(User user);
    public List<User> getAllUsers();
}
