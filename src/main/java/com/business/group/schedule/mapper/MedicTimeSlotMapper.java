package com.business.group.schedule.mapper;

import com.business.group.schedule.http.dto.MedicTimeSlotDTO;
import com.business.group.schedule.domain.entity.MedicTimeSlot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicTimeSlotMapper {
    MedicTimeSlotDTO toResponse(MedicTimeSlot medicTimeSlot);
}
