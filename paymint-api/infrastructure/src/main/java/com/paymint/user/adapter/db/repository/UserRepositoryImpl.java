package com.paymint.user.adapter.db.repository;

import com.paymint.user.model.aggregates.User;
import com.paymint.user.adapter.db.entities.UserEntity;
import com.paymint.user.adapter.db.mappers.UserEntityMapper;
import com.paymint.user.ports.repositories.UserRepository;
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
