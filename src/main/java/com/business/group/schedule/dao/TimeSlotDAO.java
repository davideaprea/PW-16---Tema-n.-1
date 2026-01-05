package com.business.group.schedule.dao;

import com.business.group.schedule.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotDAO extends JpaRepository<TimeSlot, Long> {
}
