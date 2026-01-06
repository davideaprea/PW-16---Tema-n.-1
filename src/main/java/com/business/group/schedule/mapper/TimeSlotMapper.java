package com.business.group.schedule.mapper;

import com.business.group.schedule.dto.MedicalCentreCalendarCreateRequest;
import com.business.group.schedule.dto.MedicalCentreCalendarCreateResponse;
import com.business.group.schedule.entity.CentreTimeSlot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TimeSlotMapper {
    CentreTimeSlot toEntity(MedicalCentreCalendarCreateRequest.OpeningDayDTO.SlotDTO dto);

    MedicalCentreCalendarCreateResponse.OpeningDayDTO.TimeSlotDTO toResponse(CentreTimeSlot centreTimeSlot);
}
