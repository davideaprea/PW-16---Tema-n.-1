package com.business.location.mapper;

import com.business.location.dto.response.MedicalCentreCreateResponse;
import com.business.location.entity.Address;
import com.business.location.entity.Floor;
import com.business.location.entity.MedicalCentre;
import com.business.location.entity.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicalCentreResponseMapper {
    MedicalCentreCreateResponse toResponse(MedicalCentre entity);

    MedicalCentreCreateResponse.AddressDTO toAddressDto(Address address);

    MedicalCentreCreateResponse.FloorDTO toFloorDto(Floor floor);

    MedicalCentreCreateResponse.FloorDTO.RoomDTO toRoomDto(Room room);
}
