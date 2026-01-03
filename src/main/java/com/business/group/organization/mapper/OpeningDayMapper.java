package com.business.group.organization.mapper;

import com.business.group.organization.dto.MedicalCentreCalendarCreateRequest;
import com.business.group.organization.entity.OpeningDay;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = TimeSlotMapper.class)
public interface OpeningDayMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "calendar", ignore = true)
    OpeningDay toEntity(MedicalCentreCalendarCreateRequest.OpeningDayDTO dto);

    @AfterMapping
    default void linkTimeSlots(@MappingTarget OpeningDay openingDay) {
        if (openingDay.getTimeSlots() != null) {
            openingDay.getTimeSlots()
                    .forEach(ts -> ts.setOpeningDay(openingDay));
        }
    }
}
