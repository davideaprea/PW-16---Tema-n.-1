package com.business.group.profile.domain.dto;

public record MedicDTO(
        long id,
        String biography,
        String licenseNumber,
        String name,
        String surname,
        long userId
) {
}
