package com.paymint.db;

import com.paymint.models.entities.User;
import com.paymint.models.entities.UserEntity;
import com.paymint.repositories.JpaUserRepository;
import com.paymint.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public void createUser(User user) {
        UserEntity dto = new UserEntity();
        dto.setId(user.getId().value());
        dto.setAccountStatus(user.getAccountStatus().value());
        dto.setDateOfBirth(user.getDateOfBirth().value().toString());
        dto.setNationalId(user.getNationalId().value());
        dto.setEmail(user.getEmail().value());
        dto.setName(user.getName().value());
        dto.setPassword(user.getPassword().hashedValue());
        dto.setPhone(user.getPhoneNumber().value());
        dto.setAddress(user.getAddress().street());
        dto.setRole(user.getRole().value());
        dto.setUsername(user.getName().value());

        UserEntity savedDto = jpaUserRepository.save(dto);
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
