package com.business.group.booking.http.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Positive;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;

@FieldNameConstants
public record BookingCreateRequest(
        @Positive
        long patientId,

        @Future
        LocalDateTime expectedStartTime,

        @Positive
        long medicTimeSlotId,

        @Positive
        long medicalCareId
) {
}
