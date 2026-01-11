package com.business.group.booking.exception;

import com.business.group.booking.dto.BookingDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class ConflictingBookingException extends RuntimeException {
    private final static String messageTemplate = "The inserted booking %s is conflicting with these existing bookings: %s";

    private final BookingDTO conflictingBooking;
    private final List<BookingDTO> existingBookings;

    public ConflictingBookingException(
            BookingDTO conflictingBooking,
            List<BookingDTO> existingBookings
    ) {
        super(messageTemplate.formatted(conflictingBooking, existingBookings));
        this.conflictingBooking = conflictingBooking;
        this.existingBookings = List.copyOf(existingBookings);
    }
}
