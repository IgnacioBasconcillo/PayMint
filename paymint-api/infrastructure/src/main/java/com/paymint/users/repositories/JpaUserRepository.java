package com.paymint.users.repositories;

import com.paymint.users.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
}
