package com.business.group.examination.domain.dto;

import com.business.group.examination.domain.enumeration.MedicalExaminationStatus;

import java.time.LocalDateTime;

public record ExaminationDTO(
        long id,
        long patientId,
        LocalDateTime expectedStartTime,
        LocalDateTime estimatedEndTime,
        long medicalCareId,
        long medicTimeSlotId,
        MedicalExaminationStatus status,
        long medicId
) {
    public record ReportDTO(
            long id,
            String documentLink
    ) {
    }
}
