package com.business.group.schedule.service;

import com.business.group.schedule.dao.MedicCalendarDAO;
import com.business.group.schedule.dao.MedicTimeSlotDAO;
import com.business.group.schedule.dto.MedicCalendarCreateRequest;
import com.business.group.schedule.dto.MedicCalendarCreateResponse;
import com.business.group.schedule.entity.MedicCalendar;
import com.business.group.schedule.entity.MedicTimeSlot;
import com.business.group.schedule.mapper.MedicCalendarMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class MedicCalendarService {
    private final MedicCalendarDAO medicCalendarDAO;
    private final MedicTimeSlotDAO medicTimeSlotDAO;
    private final MedicCalendarMapper calendarMapper;

    @Transactional
    public MedicCalendarCreateResponse create(MedicCalendarCreateRequest dto) {
        dto.timeSlots().sort(Comparator
                .comparing(MedicCalendarCreateRequest.TimeSlotDTO::dayOfWeek)
                .thenComparing(MedicCalendarCreateRequest.TimeSlotDTO::from)
        );

        for (int i = 1; i < dto.timeSlots().size(); i++) {
            final MedicCalendarCreateRequest.TimeSlotDTO curr = dto.timeSlots().get(i);
            final MedicCalendarCreateRequest.TimeSlotDTO prev = dto.timeSlots().get(i - 1);

            if (
                    curr.dayOfWeek().equals(prev.dayOfWeek()) &&
                    curr.from().isBefore(prev.to())
            ) {
                //throw
            }
        }

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
