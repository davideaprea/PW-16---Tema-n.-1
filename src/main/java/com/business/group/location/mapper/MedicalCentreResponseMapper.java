package com.business.group.location.mapper;

import com.business.group.location.dto.response.MedicalCentreCreateResponse;
import com.business.group.location.dto.response.MedicalCentreGetPageResponse;
import com.business.group.location.entity.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicalCentreResponseMapper {
    MedicalCentreCreateResponse toResponse(MedicalCentre entity);

    MedicalCentreCreateResponse.AddressDTO toAddressDto(Address address);

    MedicalCentreCreateResponse.FloorDTO toFloorDto(Floor floor);

    MedicalCentreCreateResponse.FloorDTO.RoomDTO toRoomDto(Room room);

    MedicalCentreGetPageResponse toPageResponse(MedicalCentre entity);

    MedicalCentreGetPageResponse.AddressDTO toPageAddressDto(Address address);

    MedicalCentreGetPageResponse.AddressDTO.CityDTO toPageCityDto(City city);

    default String map(City province) {
        return province != null ? province.getName() : "";
    }
}
