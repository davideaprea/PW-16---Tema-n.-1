package com.business.group.organization.dao;

import com.business.group.organization.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotDAO extends JpaRepository<TimeSlot, Long> {
}
