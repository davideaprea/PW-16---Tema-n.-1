package com.business.group.schedule.service;

import com.business.group.schedule.dao.MedicCalendarDAO;
import com.business.group.schedule.dao.MedicTimeSlotDAO;
import com.business.group.schedule.dto.MedicCalendarCreateRequest;
import com.business.group.schedule.dto.MedicCalendarCreateResponse;
import com.business.group.schedule.dto.MedicTimeSlotGetResponse;
import com.business.group.schedule.entity.MedicCalendar;
import com.business.group.schedule.entity.MedicTimeSlot;
import com.business.group.schedule.mapper.MedicCalendarMapper;
import com.business.group.schedule.mapper.MedicTimeSlotMapper;
import com.business.group.schedule.validator.TimeSlotValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicCalendarService {
    private final MedicCalendarDAO medicCalendarDAO;
    private final MedicTimeSlotDAO medicTimeSlotDAO;
    private final MedicCalendarMapper calendarMapper;
    private final TimeSlotValidator timeSlotValidator;
    private final MedicTimeSlotMapper medicTimeSlotMapper;

    @Transactional
    public MedicCalendarCreateResponse create(MedicCalendarCreateRequest dto) {
        timeSlotValidator.checkForOverlappingSlots(dto.timeSlots());

        dto.timeSlots().forEach(timeSlotDTO -> {
            timeSlotValidator.checkValidity(timeSlotDTO);

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
        //TODO: controllare che i centri siano aperti
        MedicCalendar calendar = medicCalendarDAO.save(calendarMapper.toEntity(dto));

        return calendarMapper.toResponse(calendar);
    }

    public MedicTimeSlotGetResponse getTimeSlotById(long id) {
        return medicTimeSlotMapper.toResponse(medicTimeSlotDAO
                .getActiveById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }
}
