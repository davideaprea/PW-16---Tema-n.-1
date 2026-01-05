package com.business.group.organization.dto;

import java.time.LocalTime;

public record MedicScheduleCreateResponse(
        long id,
        long medicId,
        long roomId,
        LocalTime from,
        LocalTime to
) {
}
