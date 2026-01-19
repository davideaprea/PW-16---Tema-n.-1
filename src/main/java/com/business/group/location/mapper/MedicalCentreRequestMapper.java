package com.business.group.location.mapper;

import com.business.group.location.http.request.FloorCreateRequest;
import com.business.group.location.http.request.MedicalCentreCreateRequest;
import com.business.group.location.domain.entity.Floor;
import com.business.group.location.domain.entity.MedicalCentre;
import com.business.group.location.domain.entity.Room;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicalCentreRequestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "floors", source = "floors")
    MedicalCentre toMedicalCentre(MedicalCentreCreateRequest medicalCentre);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "medicalCentre", expression = "java(centre)")
    @Mapping(target = "rooms", expression = "java(createRooms(dto, floor))")
    Floor toFloor(
            FloorCreateRequest dto,
            @Context MedicalCentre centre
    );

    default List<Room> createRooms(
            FloorCreateRequest dto,
            Floor floor
    ) {
        List<Room> rooms = new ArrayList<>();

        for (int i = 1; i <= dto.roomsNumber(); i++) {
            rooms.add(new Room(null, i, floor));
        }

        return rooms;
    }
}
