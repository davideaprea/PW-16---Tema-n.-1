package com.business.group.schedule.dao;

import com.business.group.schedule.entity.MedicSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicScheduleDAO extends JpaRepository<MedicSchedule, Long> {
    List<MedicSchedule> findAllByRoomId(long roomId);
}
