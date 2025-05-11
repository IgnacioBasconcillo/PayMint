package com.paymint.users.adapter.db.dao;

import com.paymint.users.adapter.db.JpaUserRepository;
import com.paymint.users.adapter.db.mappers.UserEntityMapper;
import com.paymint.users.model.entities.User;
import com.paymint.users.ports.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserDaoImpl implements UserDao {
  private final JpaUserRepository jpaUserRepository;

  public UserDaoImpl(JpaUserRepository jpaUserRepository) {
    this.jpaUserRepository = jpaUserRepository;
  }

  @Override
  public List<User> getAllUsers() {
    return jpaUserRepository.findAll().stream()
        .map(UserEntityMapper::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<User> getUserById(String id) {
    return jpaUserRepository.findById(Long.valueOf(id)).map(UserEntityMapper::toDomain);
  }
}
