package com.business.group.booking.http.dto;

import java.time.LocalDateTime;

public record ConflictingMedicalExaminationResponse(
        LocalDateTime expectedStartTime,
        LocalDateTime estimatedEndTime,
        long medicTimeSlotId
) {
}
