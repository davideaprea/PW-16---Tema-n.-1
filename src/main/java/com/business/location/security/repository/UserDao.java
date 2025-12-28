package com.business.location.security.repository;

import com.business.location.security.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDao extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
