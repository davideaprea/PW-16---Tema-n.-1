package com.business.location.mapper;

import com.business.location.dto.FloorDTO;
import com.business.location.dto.MedicalCentreDTO;
import com.business.location.entity.Floor;
import com.business.location.entity.MedicalCentre;
import com.business.location.entity.Room;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicalCentreMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "floors", source = "floors")
    MedicalCentre toMedicalCentre(MedicalCentreDTO medicalCentre);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "medicalCentre", ignore = true)
    @Mapping(target = "rooms", expression = "java(createRooms(dto))")
    Floor toFloor(FloorDTO dto);

    default List<Room> createRooms(FloorDTO dto) {
        List<Room> rooms = new ArrayList<>();

        for (int i = 1; i <= dto.roomsNumber(); i++) {
            Room room = new Room();

            room.setNumber(i);

            rooms.add(room);
        }

        return rooms;
    }

    @AfterMapping
    default void linkRelations(@MappingTarget MedicalCentre centre) {
        final Iterator<Floor> floorIterator = centre.getFloorsIterator();

        while (floorIterator.hasNext()) {
            final Floor floor = floorIterator.next();

            floor.setMedicalCentre(centre);

            final Iterator<Room> roomsIterator = floor.getRoomsIterator();

            while (roomsIterator.hasNext()) {
                final Room room = roomsIterator.next();

                room.setFloor(floor);
            }
        }
    }
}
