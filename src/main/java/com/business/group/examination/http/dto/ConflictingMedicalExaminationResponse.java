package com.business.group.examination.http.dto;

import java.time.LocalDateTime;

public record ConflictingMedicalExaminationResponse(
        LocalDateTime expectedStartTime,
        LocalDateTime estimatedEndTime,
        long medicTimeSlotId
) {
}
