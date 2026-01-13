package com.business.group.schedule.http.dto;

import java.time.LocalDateTime;
import java.util.List;

public record MedicCalendarCreateResponse(
        long id,
        long ownerId,
        LocalDateTime createdAt,
        LocalDateTime validFrom,
        String notes,
        List<MedicTimeSlotDTO> timeSlots
) {
}
