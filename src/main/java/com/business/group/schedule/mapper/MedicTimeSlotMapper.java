package com.business.group.schedule.mapper;

import com.business.group.schedule.domain.entity.MedicCalendar;
import com.business.group.schedule.http.dto.MedicCalendarCreateRequest;
import com.business.group.schedule.http.dto.MedicTimeSlotDTO;
import com.business.group.schedule.domain.entity.MedicTimeSlot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MedicTimeSlotMapper {
    MedicTimeSlotDTO toResponse(MedicTimeSlot medicTimeSlot);

    @Mapping(target = "medicCalendar", source = "calendar")
    @Mapping(target = "id", ignore = true)
    MedicTimeSlot toEntity(MedicCalendarCreateRequest.TimeSlotDTO dto, MedicCalendar calendar);
}
