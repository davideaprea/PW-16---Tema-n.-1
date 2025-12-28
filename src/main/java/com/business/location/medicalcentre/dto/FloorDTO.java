package com.business.location.medicalcentre.dto;

import jakarta.validation.constraints.Positive;

public record FloorDTO(
        int number,

        @Positive
        long roomsNumber
) {
}
