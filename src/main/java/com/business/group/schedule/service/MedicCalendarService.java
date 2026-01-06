package com.business.group.schedule.service;

import com.business.group.schedule.dao.MedicCalendarDAO;
import com.business.group.schedule.dao.MedicTimeSlotDAO;
import com.business.group.schedule.dto.MedicCalendarCreateRequest;
import com.business.group.schedule.dto.MedicCalendarCreateResponse;
import com.business.group.schedule.entity.MedicCalendar;
import com.business.group.schedule.entity.MedicTimeSlot;
import com.business.group.schedule.mapper.MedicCalendarMapper;
import com.business.group.shared.time.TimeRange;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MedicCalendarService {
    private final MedicCalendarDAO medicCalendarDAO;
    private final MedicTimeSlotDAO medicTimeSlotDAO;
    private final MedicCalendarMapper calendarMapper;

    @Transactional
    public MedicCalendarCreateResponse create(MedicCalendarCreateRequest dto) {
        Map<DayOfWeek, List<MedicCalendarCreateRequest.TimeSlotDTO>> slotsGroupedByDay = dto
                .timeSlots()
                .stream()
                .collect(Collectors.groupingBy(MedicCalendarCreateRequest.TimeSlotDTO::dayOfWeek));

        slotsGroupedByDay.forEach((_, timeSlotDTOs) -> {
            TimeRange.checkForOverlappingRanges(timeSlotDTOs);
        });

        dto.timeSlots().forEach(timeSlotDTO -> {
            List<MedicTimeSlot> conflictingSlots = medicTimeSlotDAO.findByRoomAndTime(
                    timeSlotDTO.roomId(),
                    timeSlotDTO.dayOfWeek(),
                    timeSlotDTO.from(),
                    timeSlotDTO.to()
            );

            if (!conflictingSlots.isEmpty()) {
                //throw
            }
        });

        MedicCalendar calendar = medicCalendarDAO.save(calendarMapper.toEntity(dto));

        return calendarMapper.toResponse(calendar);
    }
}
