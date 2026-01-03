package com.business.group.organization.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.util.List;

public record MedicalCentreCalendarCreateRequest(
        @NotNull
        @FutureOrPresent
        Year year,

        @Positive
        long medicalCentreId,

        @NotNull
        @Size(min = 1, max = 7)
        List<@Valid OpeningDayDTO> openingDays,

        List<@Valid ClosingPeriodDTO> closingPeriods
) {
    public record OpeningDayDTO(
            @NotNull
            DayOfWeek dayOfWeek,

            @NotNull
            @Size(min = 1)
            List<@Valid TimeSlotDTO> timeSlots
    ) {
        public record TimeSlotDTO(
                @NotNull
                LocalTime start,

                @NotNull
                LocalTime end
        ) {
        }
    }

    public record ClosingPeriodDTO(
            @FutureOrPresent
            @NotNull
            LocalDateTime from,

            @FutureOrPresent
            @NotNull
            LocalDateTime to,

            @Length(max = 300)
            String cause
    ) {
    }
}
