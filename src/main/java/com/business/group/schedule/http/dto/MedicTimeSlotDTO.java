package com.business.group.schedule.http.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record MedicTimeSlotDTO(
        long id,
        LocalTime from,
        LocalTime to,
        DayOfWeek dayOfWeek,
        long roomId
) implements DailyTimeSlot {
}
