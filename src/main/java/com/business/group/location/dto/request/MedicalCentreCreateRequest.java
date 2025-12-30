package com.business.group.location.dto.request;

import com.business.group.location.annotation.Contiguous;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.List;

public record MedicalCentreCreateRequest(
        @Email
        @NotBlank
        String email,

        @NotBlank
        @Size(max = 16)
        String phone,

        @NotNull
        @Valid
        AddressDTO address,

        @Contiguous
        @NotEmpty
        List<@Valid FloorDTO> floors
) {
    public record FloorDTO(
            int number,

            @Positive
            long roomsNumber
    ) {
    }

    public record AddressDTO(
            @NotBlank
            String name,

            @NotBlank
            String number,

            @NotNull
            @DecimalMin(value = "-90.0", inclusive = true)
            @DecimalMax(value = "90.0", inclusive = true)
            BigDecimal latitude,

            @NotNull
            @DecimalMin(value = "-180.0", inclusive = true)
            @DecimalMax(value = "180.0", inclusive = true)
            BigDecimal longitude,

            @Size(max = 500)
            String notes,

            @Positive
            long cityId
    ) {
    }
}