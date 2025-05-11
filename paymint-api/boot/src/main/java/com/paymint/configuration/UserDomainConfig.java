package com.paymint.configuration;

import com.paymint.users.ports.repositories.UserRepository;
import com.paymint.users.services.UserService;
import com.paymint.users.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDomainConfig {
  @Bean
  public UserService userService(UserRepository userRepository) {
    return new UserServiceImpl(userRepository);
  }
}
