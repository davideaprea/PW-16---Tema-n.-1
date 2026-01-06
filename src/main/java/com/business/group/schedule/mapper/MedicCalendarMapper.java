package com.business.group.schedule.mapper;

import com.business.group.schedule.dto.MedicCalendarCreateRequest;
import com.business.group.schedule.dto.MedicCalendarCreateResponse;
import com.business.group.schedule.entity.MedicCalendar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicCalendarMapper {
    MedicCalendar toEntity(MedicCalendarCreateRequest createRequest);

    MedicCalendarCreateResponse toResponse(MedicCalendar calendar);
}
