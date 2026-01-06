package com.business.group.schedule.dto;

import com.business.group.shared.annotation.ValidRange;
import com.business.group.shared.time.Range;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@ValidRange
public record MedicCalendarCreateRequest(
        @Positive
        long ownerId,

        @NotNull
        @FutureOrPresent
        LocalDateTime validFrom,

        @Length(max = 500)
        String notes,

        @NotNull
        @Size(min = 1)
        List<TimeSlotDTO> timeSlots
) {
    @ValidRange
    public record TimeSlotDTO(
            @NotNull
            LocalTime from,

            @NotNull
            LocalTime to,

            @NotNull
            DayOfWeek dayOfWeek,

            @Positive
            long roomId
    ) implements Range<LocalTime> {
    }
}
