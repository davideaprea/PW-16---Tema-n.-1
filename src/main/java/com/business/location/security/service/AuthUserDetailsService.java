package com.business.location.security.service;

import com.business.location.security.entity.User;
import com.business.location.security.pojo.AuthUserDetails;
import com.business.location.security.repository.UserDao;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthUserDetailsService implements UserDetailsService {
    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));

        return new AuthUserDetails(user);
    }
}