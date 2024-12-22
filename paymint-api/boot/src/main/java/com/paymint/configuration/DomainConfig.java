package com.paymint.configuration;

import com.paymint.services.UserService;
import com.paymint.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {
    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }
}
