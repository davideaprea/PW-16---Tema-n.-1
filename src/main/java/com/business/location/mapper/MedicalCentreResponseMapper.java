package com.business.location.mapper;

import com.business.location.dto.response.MedicalCentreCreateResponse;
import com.business.location.dto.response.MedicalCentreGetPageResponse;
import com.business.location.entity.*;
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
}
