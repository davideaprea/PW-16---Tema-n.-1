package com.business.group.booking.domain.exception;

import com.business.group.booking.http.dto.BookingCreateRequest;
import com.business.group.shared.exception.ConflictingResourceException;
import lombok.Getter;

import java.util.List;

@Getter
public class ConflictingBookingException extends ConflictingResourceException {
    public ConflictingBookingException(BookingCreateRequest conflictingBooking) {
        super("The selected time range is already booked.", conflictingBooking, List.of());
    }
}
