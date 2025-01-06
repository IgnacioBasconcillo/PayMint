package com.paymint.repositories;

import com.paymint.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
}
