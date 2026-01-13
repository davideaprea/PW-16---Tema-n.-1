package com.business.group.booking.http.dto;

import com.business.group.booking.domain.enumeration.BookingStatus;
import com.business.group.booking.domain.enumeration.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BookingDTO(
        long id,
        long patientId,
        LocalDateTime expectedStartTime,
        LocalDateTime estimatedEndTime,
        long medicalCareId,
        long medicTimeSlotId,
        BookingStatus bookingStatus,
        LocalDateTime createdAt,
        PaymentStatus paymentStatus,
        BigDecimal totalPrice
) {
}
