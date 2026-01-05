package com.business.group.schedule.dao;

import com.business.group.schedule.entity.ClosingPeriod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClosingPeriodDAO extends JpaRepository<ClosingPeriod, Long> {
}
