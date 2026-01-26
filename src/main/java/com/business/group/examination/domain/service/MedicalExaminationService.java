package com.business.group.examination.domain.service;

import com.business.group.examination.dao.MedicalExaminationDAO;
import com.business.group.examination.http.dto.MedicalExaminationGetResponse;
import com.business.group.examination.http.dto.MedicalExaminationCreateRequest;
import com.business.group.examination.http.dto.MedicalExaminationCreateResponse;
import com.business.group.examination.domain.entity.MedicalExamination;
import com.business.group.examination.mapper.MedicalExaminationMapper;
import com.business.group.healthcare.http.dto.RoomMedicalCareGetResponse;
import com.business.group.healthcare.domain.service.RoomMedicalCareService;
import com.business.group.schedule.http.dto.MedicTimeSlotDTO;
import com.business.group.schedule.domain.service.MedicCalendarService;
import com.business.group.shared.exception.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class MedicalExaminationService {
    private final MedicalExaminationDAO medicalExaminationDAO;
    private final MedicCalendarService medicCalendarService;
    private final RoomMedicalCareService roomMedicalCareService;
    private final MedicalExaminationMapper medicalExaminationMapper;

    public MedicalExaminationCreateResponse create(MedicalExaminationCreateRequest createRequest) {
        MedicTimeSlotDTO medicTimeSlot = medicCalendarService.getTimeSlotById(createRequest.medicTimeSlotId());
        RoomMedicalCareGetResponse roomService = roomMedicalCareService.getByMedicalCareIdAndRoomId(createRequest.medicalCareId(), medicTimeSlot.roomId());
        LocalDateTime expectedStartTime = createRequest.expectedStartTime();
        LocalDateTime estimatedEndTime = expectedStartTime.plus(roomService.medicalCare().duration());
        List<MedicalExamination> slotMedicalExaminations = medicalExaminationDAO.findAllBetweenDateRange(
                createRequest.medicTimeSlotId(),
                expectedStartTime,
                estimatedEndTime
        );

        if (!slotMedicalExaminations.isEmpty()) {
            throw new ConflictingResourceException(new ConflictingResourceError(
                    createRequest,
                    slotMedicalExaminations.stream().map(medicalExaminationMapper::toResponse).toList(),
                    "This slot is already booked."
            ));
        }

        if (
                !expectedStartTime.getDayOfWeek().equals(medicTimeSlot.dayOfWeek()) ||
                expectedStartTime.toLocalTime().isBefore(medicTimeSlot.startTime()) ||
                estimatedEndTime.toLocalTime().isAfter(medicTimeSlot.endTime())
        ) {
            throw new InvalidPayloadException(new InvalidPayloadError(
                    MedicalExaminationCreateRequest.Fields.expectedStartTime,
                    "the selected time slot %s is unavailable for this date.".formatted(medicTimeSlot),
                    createRequest
            ));
        }

        return medicalExaminationMapper.toDTO(medicalExaminationDAO.save(medicalExaminationMapper.toEntity(
                createRequest,
                estimatedEndTime,
                medicTimeSlot.medicCalendar().ownerId()
        )));
    }

    public MedicalExaminationGetResponse getById(long id) {
        return medicalExaminationMapper.toGetResponse(medicalExaminationDAO
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Map.of("id", id))));
    }
}
