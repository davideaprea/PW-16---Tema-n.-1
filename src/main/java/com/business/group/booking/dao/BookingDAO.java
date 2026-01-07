package com.business.group.booking.dao;

import com.business.group.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDAO extends JpaRepository<Booking, Long> {
}
