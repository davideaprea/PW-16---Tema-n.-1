package com.business.group.schedule.dto;

import com.business.group.shared.annotation.ValidRange;
import com.business.group.shared.time.Range;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.time.*;
import java.util.List;

public record CentreCalendarCreateRequest(
        @NotNull
        @FutureOrPresent
        LocalDateTime validFrom,

        @Positive
        long ownerId,

        @Length(max = 500)
        String notes,

        @NotNull
        @Size(min = 1, max = 7)
        List<@Valid TimeSlotDTO> timeSlots,

        List<@Valid ClosingPeriodDTO> closingPeriods
) {
    @ValidRange
    public record TimeSlotDTO(
            @NotNull
            LocalTime from,

            @NotNull
            LocalTime to,

            @NotNull
            DayOfWeek dayOfWeek
    ) implements Range<LocalTime> {
    }

    @ValidRange
    public record ClosingPeriodDTO(
            @FutureOrPresent
            @NotNull
            LocalDateTime from,

            @FutureOrPresent
            @NotNull
            LocalDateTime to,

            @Length(max = 300)
            String cause
    ) implements Range<LocalDateTime> {
    }
}
