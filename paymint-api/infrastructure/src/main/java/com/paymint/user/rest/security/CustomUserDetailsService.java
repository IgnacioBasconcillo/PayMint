package com.paymint.user.rest.security;

import com.paymint.user.ports.dao.UserDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
  private final UserDao userDao;

  public CustomUserDetailsService(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userDao
            .getUserByEmail(username)
        .map(SecurityUserAdapter::new)
        .orElseThrow(
            () -> new UsernameNotFoundException("User not found with username: " + username));
  }
}
