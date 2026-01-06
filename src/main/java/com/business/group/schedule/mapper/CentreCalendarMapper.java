package com.business.group.schedule.mapper;

import com.business.group.schedule.dto.CentreCalendarCreateRequest;
import com.business.group.schedule.dto.CentreCalendarCreateResponse;
import com.business.group.schedule.entity.CentreCalendar;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(
        componentModel = "spring",
        uses = {ClosingPeriodMapper.class}
)
public interface CentreCalendarMapper {
    CentreCalendar toEntity(CentreCalendarCreateRequest request);

    @AfterMapping
    default void linkChildren(@MappingTarget CentreCalendar calendar) {
        if (calendar.getCentreClosingPeriods() != null) {
            calendar
                    .getCentreClosingPeriods()
                    .forEach(cp -> cp.setCalendar(calendar));
        }
    }

    CentreCalendarCreateResponse toResponse(CentreCalendar calendar);
}
