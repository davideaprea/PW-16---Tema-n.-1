package com.business.group.schedule.http.dto;

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
        List<@Valid TimeSlotDTO> timeSlots
) {
    public record TimeSlotDTO(
            @NotNull
            LocalTime from,

            @NotNull
            LocalTime to,

            @NotNull
            DayOfWeek dayOfWeek
    ) implements DailyTimeSlot {
    }
}
