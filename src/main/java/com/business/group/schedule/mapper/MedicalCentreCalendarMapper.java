package com.business.group.schedule.mapper;

import com.business.group.schedule.dto.MedicalCentreCalendarCreateRequest;
import com.business.group.schedule.dto.MedicalCentreCalendarCreateResponse;
import com.business.group.schedule.entity.MedicalCentreCalendar;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(
        componentModel = "spring",
        uses = {
                OpeningDayMapper.class,
                ClosingPeriodMapper.class
        }
)
public interface MedicalCentreCalendarMapper {
    @Mapping(target = "id", ignore = true)
    MedicalCentreCalendar toEntity(MedicalCentreCalendarCreateRequest request);

    @AfterMapping
    default void linkChildren(@MappingTarget MedicalCentreCalendar calendar) {
        if (calendar.getOpeningDays() != null) {
            calendar.getOpeningDays()
                    .forEach(od -> od.setCalendar(calendar));
        }

        if (calendar.getClosingPeriods() != null) {
            calendar.getClosingPeriods()
                    .forEach(cp -> cp.setCalendar(calendar));
        }
    }

    MedicalCentreCalendarCreateResponse toResponse(MedicalCentreCalendar calendar);
}
