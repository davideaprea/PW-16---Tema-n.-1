package com.business.group.location.mapper;

import com.business.group.location.domain.entity.Address;
import com.business.group.location.domain.entity.City;
import com.business.group.location.http.request.AddressCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "city", source = "cityId")
    @Mapping(target = "medicalCentre", ignore = true)
    Address toEntity(AddressCreateRequest dto);

    default City map(Long cityId) {
        if (cityId == null) {
            return null;
        }

        City city = new City();

        city.setId(cityId);

        return city;
    }
}
