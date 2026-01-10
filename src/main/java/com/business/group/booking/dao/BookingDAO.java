package com.business.group.booking.dao;

import com.business.group.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingDAO extends JpaRepository<Booking, Long> {
    @Query("""
            SELECT b
            FROM Booking b
            WHERE b.medicTimeSlotId = :medicTimeSlotId AND
                b.expectedStartTime < :to AND
                b.estimatedEndTime > :from
            """)
    List<Booking> findAllBetweenDateRange(
            long medicTimeSlotId,
            LocalDateTime from,
            LocalDateTime to
    );
}
