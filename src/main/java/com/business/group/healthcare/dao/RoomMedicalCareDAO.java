package com.business.group.healthcare.dao;

import com.business.group.healthcare.entity.RoomMedicalCare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomMedicalCareDAO extends JpaRepository<RoomMedicalCare, Long> {
    Optional<RoomMedicalCare> findByMedicalCareIdAndRoomId(long medicalCareId, long roomId);
}
