package com.business.group.schedule.mapper;

import com.business.group.schedule.dto.MedicalCentreCalendarCreateRequest;
import com.business.group.schedule.dto.MedicalCentreCalendarCreateResponse;
import com.business.group.schedule.entity.CentreWorkingDay;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = TimeSlotMapper.class)
public interface OpeningDayMapper {
    CentreWorkingDay toEntity(MedicalCentreCalendarCreateRequest.OpeningDayDTO dto);

    @AfterMapping
    default void linkTimeSlots(@MappingTarget CentreWorkingDay centreWorkingDay) {
        if (centreWorkingDay.getCentreTimeSlots() != null) {
            centreWorkingDay.getCentreTimeSlots()
                    .forEach(ts -> ts.setCentreWorkingDay(centreWorkingDay));
        }
    }

    MedicalCentreCalendarCreateResponse.OpeningDayDTO toResponse(CentreWorkingDay centreWorkingDay);
}
