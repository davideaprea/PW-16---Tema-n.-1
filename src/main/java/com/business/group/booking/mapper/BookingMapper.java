package com.business.group.booking.mapper;

import com.business.group.booking.http.dto.BookingCreateRequest;
import com.business.group.booking.http.dto.BookingDTO;
import com.business.group.booking.domain.entity.Booking;
import com.business.group.booking.http.dto.ConflictingBookingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mapping(target = "bookingStatus", constant = "CREATED")
    Booking toEntity(
            BookingCreateRequest createRequest,
            LocalDateTime estimatedEndTime
    );

    BookingDTO toDTO(Booking booking);

    ConflictingBookingResponse toResponse(Booking booking);
}
