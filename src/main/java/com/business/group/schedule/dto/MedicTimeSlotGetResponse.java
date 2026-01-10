package com.business.group.schedule.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record MedicTimeSlotGetResponse(
        long id,
        LocalTime from,
        LocalTime to,
        DayOfWeek dayOfWeek,
        long roomId
) {
}
