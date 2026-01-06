package com.business.group.schedule.dto;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public record MedicCalendarCreateResponse(
        long id,
        long ownerId,
        LocalDateTime createdAt,
        LocalDateTime validFrom,
        String notes,
        List<TimeSlotDTO> timeSlots
) {
    public record TimeSlotDTO(
            long id,
            long roomId,
            LocalTime from,
            LocalTime to,
            DayOfWeek dayOfWeek
    ) {
    }
}
