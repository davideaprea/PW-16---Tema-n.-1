package com.business.group.schedule.dao;

import com.business.group.schedule.entity.CentreCalendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalCentreCalendarDAO extends JpaRepository<CentreCalendar, Long> {
}
