package com.business.group.schedule.dao;

import com.business.group.schedule.entity.OpeningDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpeningDayDAO extends JpaRepository<OpeningDay, Long> {
}
