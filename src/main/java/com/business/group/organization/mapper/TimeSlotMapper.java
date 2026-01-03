package com.business.group.organization.mapper;

import com.business.group.organization.dto.MedicalCentreCalendarCreateRequest;
import com.business.group.organization.entity.TimeSlot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TimeSlotMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "openingDay", ignore = true)
    TimeSlot toEntity(MedicalCentreCalendarCreateRequest.OpeningDayDTO.TimeSlotDTO dto);
}
