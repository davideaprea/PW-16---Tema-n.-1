package com.business.group.schedule.service;

import com.business.group.schedule.dao.MedicCalendarDAO;
import com.business.group.schedule.dao.MedicTimeSlotDAO;
import com.business.group.schedule.dto.MedicCalendarCreateRequest;
import com.business.group.schedule.dto.MedicCalendarCreateResponse;
import com.business.group.schedule.entity.MedicTimeSlot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicCalendarService {
    private final MedicCalendarDAO medicCalendarDAO;
    private final MedicTimeSlotDAO medicTimeSlotDAO;

    public MedicCalendarCreateResponse create(MedicCalendarCreateRequest dto) {
        dto.timeSlots().forEach(timeSlotDTO -> {
            List<MedicTimeSlot> conflictingSlots = medicTimeSlotDAO.findByRoomAndTime(
                    timeSlotDTO.roomId(),
                    timeSlotDTO.dayOfWeek(),
                    timeSlotDTO.from(),
                    timeSlotDTO.to()
            );

            if(!conflictingSlots.isEmpty()) {
                //throw
            }
        });
    }
}
