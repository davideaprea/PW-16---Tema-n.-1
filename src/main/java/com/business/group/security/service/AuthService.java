package com.business.group.security.service;

import com.business.group.security.component.JWTCreator;
import com.business.group.security.dto.AuthUserDetails;
import com.business.group.security.entity.User;
import com.business.group.security.dto.LoginCreateRequest;
import com.business.group.security.dto.UserCreateRequest;
import com.business.group.security.dao.UserDAO;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthService {
    private final UserDAO userDao;
    private final JWTCreator jwtCreator;
    private final AuthenticationManager authManager;
    private final PasswordEncoder encoder;

    public User register(UserCreateRequest credentials) {
        return userDao.save(User.create(
                credentials.email(),
                encoder.encode(credentials.password())
        ));
    }

    public String login(LoginCreateRequest credentials) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        credentials.email(),
                        credentials.password()
                )
        );

        if ((authentication.getPrincipal() instanceof AuthUserDetails userDetails)) {
            return jwtCreator.withSubject(userDetails.getUsername());
        }

        throw new AuthenticationServiceException("Unexpected principal type: " + authentication.getPrincipal().getClass().getName());
    }
}
