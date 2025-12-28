package com.business.location.medicalcentre.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;

public record MedicalCentreDTO(
        @Email
        @NotBlank
        String email,

        @NotBlank
        @Size(max = 16)
        String phone,

        @NotNull
        @Valid
        AddressDTO address,

        @NotEmpty
        List<@Valid FloorDTO> floors
) {
}
