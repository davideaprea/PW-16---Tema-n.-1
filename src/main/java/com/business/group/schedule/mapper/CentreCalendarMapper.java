package com.business.group.schedule.mapper;

import com.business.group.schedule.dto.CentreCalendarCreateRequest;
import com.business.group.schedule.dto.CentreCalendarCreateResponse;
import com.business.group.schedule.entity.CentreCalendar;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CentreCalendarMapper {
    CentreCalendar toEntity(CentreCalendarCreateRequest request);

    CentreCalendarCreateResponse toResponse(CentreCalendar calendar);
}
