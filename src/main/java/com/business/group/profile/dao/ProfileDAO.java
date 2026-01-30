package com.business.group.profile.dao;

import com.business.group.profile.domain.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface ProfileDAO<T extends Profile> extends JpaRepository<T, Long> {
    Optional<T> findByUserId(long userId);
}
