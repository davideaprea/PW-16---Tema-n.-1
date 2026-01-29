package com.business.group.schedule.http.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record MedicCalendarCreateRequest(
        @Positive
        long ownerId,

        @NotNull
        @FutureOrPresent
        LocalDate validFrom,

        @Length(max = 500)
        String notes,

        @NotNull
        @Size(min = 1)
        List<@Valid TimeSlotDTO> timeSlots
) {
    public record TimeSlotDTO(
            @NotNull
            LocalTime startTime,

            @NotNull
            LocalTime endTime,

            @NotNull
            DayOfWeek dayOfWeek,

            @Positive
            long roomId
    ) implements DailyTimeSlot {
    }
}
