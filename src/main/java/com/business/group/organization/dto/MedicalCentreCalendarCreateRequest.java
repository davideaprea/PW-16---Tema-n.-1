package com.business.group.organization.dto;

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
            List<@Valid SlotDTO> timeSlots
    ) {
        @ValidRange
        public record SlotDTO(
                @NotNull
                LocalTime from,

                @NotNull
                LocalTime to
        ) implements Range<LocalTime> {
            @Override
            public boolean isValid() {
                return from.isBefore(to);
            }
        }
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
        @Override
        public boolean isValid() {
            return from.isBefore(to);
        }
    }
}
