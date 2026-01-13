package com.business.group.schedule.mapper;

import com.business.group.schedule.http.dto.CentreCalendarCreateRequest;
import com.business.group.schedule.http.dto.CentreCalendarCreateResponse;
import com.business.group.schedule.domain.entity.CentreCalendar;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CentreCalendarMapper {
    CentreCalendar toEntity(CentreCalendarCreateRequest request);

    CentreCalendarCreateResponse toResponse(CentreCalendar calendar);
}
