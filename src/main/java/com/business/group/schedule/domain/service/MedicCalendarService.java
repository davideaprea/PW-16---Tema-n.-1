package com.business.group.schedule.domain.service;

import com.business.group.schedule.dao.MedicCalendarDAO;
import com.business.group.schedule.dao.MedicTimeSlotDAO;
import com.business.group.schedule.http.dto.MedicCalendarCreateRequest;
import com.business.group.schedule.http.dto.MedicCalendarCreateResponse;
import com.business.group.schedule.http.dto.MedicTimeSlotDTO;
import com.business.group.schedule.domain.entity.MedicCalendar;
import com.business.group.schedule.domain.entity.MedicTimeSlot;
import com.business.group.schedule.mapper.MedicCalendarMapper;
import com.business.group.schedule.mapper.MedicTimeSlotMapper;
import com.business.group.schedule.domain.validator.TimeSlotValidator;
import com.business.group.shared.exception.ConflictingResourceError;
import com.business.group.shared.exception.ConflictingResourceException;
import com.business.group.shared.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

        MedicCalendar calendarToSave = calendarMapper.toEntity(dto);

        List<MedicTimeSlot> timeSlots = dto.timeSlots()
                .stream()
                .peek(timeSlotDTO -> {
                    timeSlotValidator.checkValidity(timeSlotDTO);

                    List<MedicTimeSlot> conflictingSlots = medicTimeSlotDAO.findByRoomAndTime(
                            timeSlotDTO.roomId(),
                            timeSlotDTO.dayOfWeek(),
                            timeSlotDTO.startTime(),
                            timeSlotDTO.endTime()
                    );

                    if (!conflictingSlots.isEmpty()) {
                        throw new ConflictingResourceException(new ConflictingResourceError(
                                timeSlotDTO,
                                conflictingSlots.stream().map(medicTimeSlotMapper::toResponse).toList(),
                                "The inserted time slot is overlapping with other time slots."
                        ));
                    }
                })
                .map(timeSlotDTO -> medicTimeSlotMapper.toEntity(timeSlotDTO, calendarToSave))
                .toList();

        calendarToSave.setTimeSlots(timeSlots);

        MedicCalendar savedCalendar = medicCalendarDAO.save(calendarToSave);

        return calendarMapper.toResponse(savedCalendar);
    }

    public MedicTimeSlotDTO getTimeSlotById(long id) {
        return medicTimeSlotMapper.toResponse(medicTimeSlotDAO
                .getActiveById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Map.of("id", id))));
    }
}
