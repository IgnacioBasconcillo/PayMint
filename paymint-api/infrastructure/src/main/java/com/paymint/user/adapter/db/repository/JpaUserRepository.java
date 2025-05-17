package com.paymint.user.adapter.db.repository;

import com.paymint.user.adapter.db.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
}
