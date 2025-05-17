package com.paymint.user.adapter.db.dao;

import com.paymint.user.adapter.db.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserDao extends JpaRepository<UserEntity, Long> {
  Optional<UserEntity> findByEmail(String email);
}
