package com.business.group.booking.domain.service;

import com.business.group.booking.dao.BookingDAO;
import com.business.group.booking.http.dto.BookingCreateRequest;
import com.business.group.booking.http.dto.BookingDTO;
import com.business.group.booking.domain.entity.Booking;
import com.business.group.booking.mapper.BookingMapper;
import com.business.group.healthcare.http.dto.RoomMedicalCareGetResponse;
import com.business.group.healthcare.domain.service.RoomMedicalCareService;
import com.business.group.schedule.http.dto.MedicTimeSlotDTO;
import com.business.group.schedule.domain.service.MedicCalendarService;
import com.business.group.shared.exception.ConflictingResourceError;
import com.business.group.shared.exception.ConflictingResourceException;
import com.business.group.shared.exception.InvalidPayloadError;
import com.business.group.shared.exception.InvalidPayloadException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class BookingService {
    private final BookingDAO bookingDAO;
    private final MedicCalendarService medicCalendarService;
    private final RoomMedicalCareService roomMedicalCareService;
    private final BookingMapper bookingMapper;

    public BookingDTO create(BookingCreateRequest createRequest) {
        MedicTimeSlotDTO medicTimeSlot = medicCalendarService.getTimeSlotById(createRequest.medicTimeSlotId());
        RoomMedicalCareGetResponse roomService = roomMedicalCareService.getByMedicalCareIdAndRoomId(createRequest.medicalCareId(), medicTimeSlot.roomId());
        LocalDateTime expectedStartTime = createRequest.expectedStartTime();
        LocalDateTime estimatedEndTime = expectedStartTime.plus(roomService.medicalCare().duration());
        List<Booking> slotBookings = bookingDAO.findAllBetweenDateRange(
                createRequest.medicTimeSlotId(),
                expectedStartTime,
                estimatedEndTime
        );

        if (!slotBookings.isEmpty()) {
            throw new ConflictingResourceException(new ConflictingResourceError(
                    createRequest,
                    slotBookings.stream().map(bookingMapper::toDTO).toList(),
                    "This slot is already booked."
            ));
        }

        if (
                !expectedStartTime.getDayOfWeek().equals(medicTimeSlot.dayOfWeek()) ||
                expectedStartTime.toLocalTime().isBefore(medicTimeSlot.from()) ||
                estimatedEndTime.toLocalTime().isAfter(medicTimeSlot.to())
        ) {
            throw new InvalidPayloadException(new InvalidPayloadError(
                    BookingCreateRequest.Fields.expectedStartTime,
                    "the selected time slot %s is unavailable for this date.".formatted(medicTimeSlot),
                    createRequest
            ));
        }

        return bookingMapper.toDTO(bookingDAO.save(bookingMapper.toEntity(
                createRequest,
                estimatedEndTime,
                roomService.price()
        )));
    }
}
