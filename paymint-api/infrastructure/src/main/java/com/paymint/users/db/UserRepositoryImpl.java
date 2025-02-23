package com.paymint.users.db;

import com.paymint.users.models.entities.User;
import com.paymint.users.models.entities.UserEntity;
import com.paymint.users.models.mappers.UserEntityMapper;
import com.paymint.users.repositories.JpaUserRepository;
import com.paymint.users.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<User> getAllUsers() {
        return jpaUserRepository.findAll()
                .stream()
                .map(UserEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> getUserById(String id) {
        return jpaUserRepository.findById(Long.valueOf(id)).map(UserEntityMapper::toDomain);
    }
}
