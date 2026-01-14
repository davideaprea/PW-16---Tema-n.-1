package com.business.group.booking.http.dto;

import java.time.LocalDateTime;

public record ConflictingBookingResponse(
        LocalDateTime expectedStartTime,
        LocalDateTime estimatedEndTime,
        long medicTimeSlotId
) {
}
