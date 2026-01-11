package com.business.group.booking.service;

import com.business.group.booking.dao.BookingDAO;
import com.business.group.booking.dto.BookingCreateRequest;
import com.business.group.booking.dto.BookingCreateResponse;
import com.business.group.booking.entity.Booking;
import com.business.group.booking.mapper.BookingMapper;
import com.business.group.healthcare.dto.RoomMedicalCareGetResponse;
import com.business.group.healthcare.service.RoomMedicalCareService;
import com.business.group.schedule.dto.MedicTimeSlotDTO;
import com.business.group.schedule.service.MedicCalendarService;
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

    public BookingCreateResponse create(BookingCreateRequest createRequest) {
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
            //throw
        }


        if (
                !expectedStartTime.getDayOfWeek().equals(medicTimeSlot.dayOfWeek()) ||
                expectedStartTime.toLocalTime().isBefore(medicTimeSlot.from()) ||
                estimatedEndTime.toLocalTime().isAfter(medicTimeSlot.to())
        ) {
            //throw
        }

        return bookingMapper.toCreateResponse(bookingDAO.save(bookingMapper.toEntity(
                createRequest,
                estimatedEndTime,
                roomService.price()
        )));
    }
}
