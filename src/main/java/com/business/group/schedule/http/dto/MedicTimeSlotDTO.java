package com.business.group.schedule.http.dto;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record MedicTimeSlotDTO(
        long id,
        LocalTime startTime,
        LocalTime endTime,
        DayOfWeek dayOfWeek,
        long roomId,
        MedicCalendarDTO medicCalendar
) implements DailyTimeSlot {
    public record MedicCalendarDTO(
            long id,
            long ownerId,
            LocalDateTime createdAt,
            LocalDateTime validFrom,
            String notes
    ) {}
}
