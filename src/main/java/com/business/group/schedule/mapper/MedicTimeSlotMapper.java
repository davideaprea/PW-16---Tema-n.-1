package com.business.group.schedule.mapper;

import com.business.group.schedule.dto.MedicTimeSlotDTO;
import com.business.group.schedule.entity.MedicTimeSlot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicTimeSlotMapper {
    MedicTimeSlotDTO toResponse(MedicTimeSlot medicTimeSlot);
}
