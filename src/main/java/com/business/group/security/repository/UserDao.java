package com.business.group.security.repository;

import com.business.group.security.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDao extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
