package com.business.group.location.http.response;

public record MedicalCentreGetPageResponse(
        long id,
        String email,
        String phone,
        AddressDTO address
) {
    public record AddressDTO(
            String name,
            String number,
            String notes,
            CityDTO city
    ) {
        public record CityDTO(
                long id,
                String name,
                String province,
                String zipCode
        ) {}
    }
}
