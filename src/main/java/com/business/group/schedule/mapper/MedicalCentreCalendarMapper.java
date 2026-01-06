package com.business.group.schedule.mapper;

import com.business.group.schedule.dto.MedicalCentreCalendarCreateRequest;
import com.business.group.schedule.dto.MedicalCentreCalendarCreateResponse;
import com.business.group.schedule.entity.CentreCalendar;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(
        componentModel = "spring",
        uses = {
                OpeningDayMapper.class,
                ClosingPeriodMapper.class
        }
)
public interface MedicalCentreCalendarMapper {
    CentreCalendar toEntity(MedicalCentreCalendarCreateRequest request);

    @AfterMapping
    default void linkChildren(@MappingTarget CentreCalendar calendar) {
        if (calendar.getCentreWorkingDays() != null) {
            calendar.getCentreWorkingDays()
                    .forEach(od -> od.setCalendar(calendar));
        }

        if (calendar.getCentreClosingPeriods() != null) {
            calendar.getCentreClosingPeriods()
                    .forEach(cp -> cp.setCalendar(calendar));
        }
    }

    MedicalCentreCalendarCreateResponse toResponse(CentreCalendar calendar);
}
