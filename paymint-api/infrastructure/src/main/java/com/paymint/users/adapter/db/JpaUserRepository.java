package com.paymint.users.adapter.db;

import com.paymint.users.adapter.db.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
}
