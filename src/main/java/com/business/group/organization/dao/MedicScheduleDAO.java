package com.business.group.organization.dao;

import com.business.group.organization.entity.MedicSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicScheduleDAO extends JpaRepository<MedicSchedule, Long> {
    List<MedicSchedule> findAllByRoomId(long roomId);
}
