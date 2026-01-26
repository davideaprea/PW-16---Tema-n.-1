package com.business.group.location.mapper;

import com.business.group.location.http.request.FloorCreateRequest;
import com.business.group.location.http.request.MedicalCentreCreateRequest;
import com.business.group.location.domain.entity.Floor;
import com.business.group.location.domain.entity.MedicalCentre;
import com.business.group.location.domain.entity.Room;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {AddressMapper.class}
)
public interface MedicalCentreRequestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "floors", ignore = true)
    MedicalCentre toMedicalCentre(MedicalCentreCreateRequest dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "medicalCentre", ignore = true)
    @Mapping(target = "rooms", ignore = true)
    Floor toFloor(FloorCreateRequest dto);

    @AfterMapping
    default void linkFloorsAndRooms(
            MedicalCentreCreateRequest dto,
            @MappingTarget MedicalCentre centre
    ) {
        List<Floor> floors = new ArrayList<>();

        for (FloorCreateRequest floorDto : dto.floors()) {

            Floor floor = toFloor(floorDto);

            floor.setMedicalCentre(centre);

            List<Room> rooms = new ArrayList<>();
            for (int i = 1; i <= floorDto.roomsNumber(); i++) {
                rooms.add(new Room(null, i, floor));
            }

            floor.setRooms(rooms);
            floors.add(floor);
        }

        centre.setFloors(floors);
    }
}
