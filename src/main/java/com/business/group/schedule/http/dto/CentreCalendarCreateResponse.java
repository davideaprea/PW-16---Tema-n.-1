package com.business.group.schedule.http.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public record CentreCalendarCreateResponse(
        long id,
        long ownerId,
        LocalDateTime createdAt,
        LocalDateTime validFrom,
        String notes,
        List<TimeSlotDTO> timeSlots
) {
    public record TimeSlotDTO(
            long id,
            LocalTime from,
            LocalTime to
    ) {
    }
}
