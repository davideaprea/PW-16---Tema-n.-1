package com.business.group.booking.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record BookingCreateRequest(
        @Positive
        long patientId,

        @Future
        LocalDateTime expectedStartTime,

        @Positive
        long roomId,

        @Positive
        long medicalCareId
) {
}
