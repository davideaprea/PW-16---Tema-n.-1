package com.business.group.examination.http.dto;

import com.business.group.examination.domain.enumeration.MedicalExaminationStatus;

import java.time.LocalDateTime;

public record MedicalExaminationCreateResponse(
        long id,
        long patientId,
        LocalDateTime expectedStartTime,
        LocalDateTime estimatedEndTime,
        long medicalCareId,
        long medicTimeSlotId,
        MedicalExaminationStatus medicalExaminationStatus,
        LocalDateTime createdAt
) {
}
