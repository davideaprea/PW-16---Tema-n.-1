package com.business.group.healthcare.dao;

import com.business.group.healthcare.entity.CentreService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CentreServiceDAO extends JpaRepository<CentreService, Long> {
    Optional<CentreService> findByMedicalCareIdAndRoomId(long medicalCareId, long roomId);
}
