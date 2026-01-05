package com.business.group.schedule.dto;

import java.time.LocalTime;

public record MedicScheduleCreateResponse(
        long id,
        long medicId,
        long roomId,
        LocalTime from,
        LocalTime to
) {
}
