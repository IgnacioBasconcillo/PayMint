package com.paymint.user.adapter.db.dao;

import com.paymint.user.adapter.db.mappers.UserEntityMapper;
import com.paymint.user.model.aggregates.User;
import com.paymint.user.ports.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserDaoImpl implements UserDao {
  private final JpaUserDao jpaUserDao;

  public UserDaoImpl(JpaUserDao jpaUserDao) {
    this.jpaUserDao = jpaUserDao;
  }

  @Override
  public List<User> getAllUsers() {
    return jpaUserDao.findAll().stream()
        .map(UserEntityMapper::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<User> getUserByEmail(String email) {
    return jpaUserDao.findByEmail(email).map(UserEntityMapper::toDomain);
  }
}
