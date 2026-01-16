package com.business.group.schedule.dao;

import com.business.group.schedule.domain.entity.MedicTimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface MedicTimeSlotDAO extends JpaRepository<MedicTimeSlot, Long> {
    @Query("""
            FROM MedicTimeSlot s
            WHERE s.roomId = :roomId
              AND s.dayOfWeek = :dayOfWeek
              AND s.from < :to
              AND s.to > :from
              AND s.medicCalendar.validTo IS NULL
            """)
    List<MedicTimeSlot> findByRoomAndTime(
            long roomId,
            DayOfWeek dayOfWeek,
            LocalTime from,
            LocalTime to
    );

    @Query("""
            SELECT s
            FROM MedicTimeSlot s
            WHERE s.id = :id AND s.medicCalendar.validTo IS NULL
            """)
    Optional<MedicTimeSlot> getActiveById(long id);
}
