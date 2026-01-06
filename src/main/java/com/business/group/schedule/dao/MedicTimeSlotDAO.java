package com.business.group.schedule.dao;

import com.business.group.schedule.entity.MedicTimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicTimeSlotDAO extends JpaRepository<MedicTimeSlot, Long> {
    @Query("""
            SELECT s
            FROM MedicTimeSlot s
            WHERE s.roomId IN :roomsId AND s.workingDay.calendar.validTo IS NULL
            """)
    List<MedicTimeSlot> findAllInActiveCalendarsRooms(List<Long> roomsId);
}
