package com.business.group.schedule.dao;

import com.business.group.schedule.entity.CentreClosingPeriod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClosingPeriodDAO extends JpaRepository<CentreClosingPeriod, Long> {
}
