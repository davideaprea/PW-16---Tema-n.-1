package com.business.group.booking.mapper;

import com.business.group.booking.dto.BookingCreateRequest;
import com.business.group.booking.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mapping(target = "bookingStatus", constant = "CREATED")
    @Mapping(target = "paymentStatus", constant = "PENDING")
    Booking toEntity(
            BookingCreateRequest createRequest,
            LocalDateTime estimatedEndTime,
            BigDecimal totalPrice
    );
}
