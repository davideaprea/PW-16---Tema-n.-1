package com.business.group.organization.mapper;

import com.business.group.organization.dto.MedicalCentreCalendarCreateRequest;
import com.business.group.organization.entity.ClosingPeriod;
import com.business.group.organization.entity.MedicalCentreCalendar;
import com.business.group.organization.entity.OpeningDay;
import com.business.group.organization.entity.TimeSlot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicalCentreCalendarMapper {
    MedicalCentreCalendar toMedicalCentreCalendar(MedicalCentreCalendarCreateRequest dto);

    OpeningDay toOpeningDay(MedicalCentreCalendarCreateRequest.OpeningDayDTO dto);

    TimeSlot toTimeSlot(MedicalCentreCalendarCreateRequest.OpeningDayDTO.TimeSlotDTO dto);

    ClosingPeriod toClosingPeriod(MedicalCentreCalendarCreateRequest.ClosingPeriodDTO dto);
}
