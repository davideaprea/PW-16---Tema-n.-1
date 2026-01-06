package com.business.group.schedule.dao;

import com.business.group.schedule.entity.MedicCalendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicCalendarDAO extends JpaRepository<MedicCalendar, Long> {
}
