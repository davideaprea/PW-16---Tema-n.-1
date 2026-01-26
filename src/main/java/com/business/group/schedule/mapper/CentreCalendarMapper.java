package com.business.group.schedule.mapper;

import com.business.group.location.http.request.MedicalCentreCreateRequest;
import com.business.group.schedule.domain.entity.CentreTimeSlot;
import com.business.group.schedule.http.dto.CentreCalendarCreateRequest;
import com.business.group.schedule.http.dto.CentreCalendarCreateResponse;
import com.business.group.schedule.domain.entity.CentreCalendar;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CentreCalendarMapper {
    CentreCalendar toEntity(CentreCalendarCreateRequest request);

    CentreCalendarCreateResponse toResponse(CentreCalendar calendar);

    CentreTimeSlot toTimeSlotEntity(CentreCalendarCreateRequest.TimeSlotDTO timeSlot);

    @AfterMapping
    default void linkTimeSlots(@MappingTarget CentreCalendar calendar, CentreCalendarCreateRequest request) {
        if (request.timeSlots() != null) {
            List<CentreTimeSlot> slots = request.timeSlots().stream()
                    .map(this::toTimeSlotEntity)
                    .peek(slot -> slot.setCalendar(calendar))
                    .toList();

            calendar.setTimeSlots(slots);
        }
    }
}
