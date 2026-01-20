package com.business.group.booking.http.dto;

import com.business.group.booking.domain.enumeration.MedicalExaminationStatus;

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
