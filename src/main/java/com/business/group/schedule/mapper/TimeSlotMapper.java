package com.business.group.schedule.mapper;

import com.business.group.schedule.dto.CentreCalendarCreateRequest;
import com.business.group.schedule.dto.CentreCalendarCreateResponse;
import com.business.group.schedule.entity.CentreTimeSlot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TimeSlotMapper {
    CentreTimeSlot toEntity(CentreCalendarCreateRequest.OpeningDayDTO.SlotDTO dto);

    CentreCalendarCreateResponse.OpeningDayDTO.TimeSlotDTO toResponse(CentreTimeSlot centreTimeSlot);
}
