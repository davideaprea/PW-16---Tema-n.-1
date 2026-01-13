package com.business.group.booking.domain.exception;

import com.business.group.booking.http.dto.BookingCreateRequest;
import com.business.group.booking.http.dto.BookingDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class ConflictingBookingException extends RuntimeException {
    private final static String messageTemplate = "The inserted booking %s is conflicting with these existing bookings: %s";

    private final BookingCreateRequest conflictingBooking;
    private final List<BookingDTO> existingBookings;

    public ConflictingBookingException(
            BookingCreateRequest conflictingBooking,
            List<BookingDTO> existingBookings
    ) {
        super(messageTemplate.formatted(conflictingBooking, existingBookings));
        this.conflictingBooking = conflictingBooking;
        this.existingBookings = List.copyOf(existingBookings);
    }
}
