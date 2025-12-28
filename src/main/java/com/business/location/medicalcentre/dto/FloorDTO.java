package com.business.location.medicalcentre.dto;

import jakarta.validation.constraints.Positive;

public record FloorDTO(
        long number,

        @Positive
        long roomsNumber
) {
}
