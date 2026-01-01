package com.business.group.profile.dao;

import com.business.group.profile.entity.Medic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicDAO extends JpaRepository<Medic, Long> {
}
