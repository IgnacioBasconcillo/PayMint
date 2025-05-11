package com.paymint.users.adapter.db.repository;

import com.paymint.users.model.entities.User;
import com.paymint.users.adapter.db.entities.UserEntity;
import com.paymint.users.adapter.db.mappers.UserEntityMapper;
import com.paymint.users.adapter.db.JpaUserRepository;
import com.paymint.users.ports.repositories.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private final JpaUserRepository jpaUserRepository;

  public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
    this.jpaUserRepository = jpaUserRepository;
  }

  @Override
  public void createUser(User user) {
    UserEntity userEntity = UserEntityMapper.toEntity(user);
    jpaUserRepository.save(userEntity);
  }
}
