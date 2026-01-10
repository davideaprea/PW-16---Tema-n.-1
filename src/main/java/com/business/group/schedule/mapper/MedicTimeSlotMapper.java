package com.business.group.schedule.mapper;

import com.business.group.schedule.dto.MedicTimeSlotGetResponse;
import com.business.group.schedule.entity.MedicTimeSlot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicTimeSlotMapper {
    MedicTimeSlotGetResponse toResponse(MedicTimeSlot medicTimeSlot);
}
