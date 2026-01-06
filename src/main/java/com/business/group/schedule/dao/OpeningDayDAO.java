package com.business.group.schedule.dao;

import com.business.group.schedule.entity.CentreWorkingDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpeningDayDAO extends JpaRepository<CentreWorkingDay, Long> {
}
