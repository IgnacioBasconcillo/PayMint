package com.paymint.security;

import com.paymint.models.entities.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;
import java.util.List;

public class SecurityUserAdapter implements UserDetails {
    private final User user;

    public SecurityUserAdapter(User user) {
        this.user = user;
    }

    @Override
    public List<SimpleGrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().value().toUpperCase()));
    }

    @Override
    public String getPassword() {
        return user.getPassword().hashedValue();
    }

    @Override
    public String getUsername() {
        return user.getName().value();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.getAccountStatus().value().equals("LOCKED");
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getAccountStatus().value().equals("ACTIVE");
    }
}
