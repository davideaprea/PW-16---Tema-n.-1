package com.business.group.schedule.dto;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.util.List;

public record MedicalCentreCalendarCreateResponse(
        long id,
        Year year,
        List<OpeningDayDTO> openingDays,
        List<ClosingPeriodDTO> closingPeriodDTOS
) {
    public record OpeningDayDTO(
            long id,
            DayOfWeek dayOfWeek,
            List<TimeSlotDTO> timeSlots
    ) {
        public record TimeSlotDTO(
                long id,
                LocalTime from,
                LocalTime to
        ) {
        }
    }

    public record ClosingPeriodDTO(
            long id,
            LocalDateTime from,
            LocalDateTime to,
            String cause
    ) {
    }
}
