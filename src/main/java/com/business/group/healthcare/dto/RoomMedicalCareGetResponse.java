package com.business.group.healthcare.dto;

import java.math.BigDecimal;

public record RoomMedicalCareGetResponse(
        long id,
        long roomId,
        BigDecimal price,
        MedicalCareGetResponse medicalCare
) {
}
