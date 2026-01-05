package com.business.group.schedule.mapper;

import com.business.group.schedule.dto.MedicalCentreCalendarCreateRequest;
import com.business.group.schedule.dto.MedicalCentreCalendarCreateResponse;
import com.business.group.schedule.entity.TimeSlot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TimeSlotMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "openingDay", ignore = true)
    TimeSlot toEntity(MedicalCentreCalendarCreateRequest.OpeningDayDTO.SlotDTO dto);

    MedicalCentreCalendarCreateResponse.OpeningDayDTO.TimeSlotDTO toResponse(TimeSlot timeSlot);
}
