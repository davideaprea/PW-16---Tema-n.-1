package com.business.group.organization.dto;

import com.business.group.shared.annotation.ValidRange;
import com.business.group.shared.time.Range;
import jakarta.validation.constraints.Positive;

import java.time.LocalTime;

@ValidRange
public record MedicScheduleCreateRequest(
        @Positive
        long medicId,
        @Positive
        long roomId,
        LocalTime from,
        LocalTime to
) implements Range<LocalTime> {
}
