package com.business.group.booking.controller;

import com.business.group.booking.dto.BookingCreateRequest;
import com.business.group.booking.dto.BookingCreateResponse;
import com.business.group.booking.service.BookingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
@AllArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    public ResponseEntity<BookingCreateResponse> create(
            @RequestBody
            @Valid
            BookingCreateRequest createRequest
    ) {
        return new ResponseEntity<>(bookingService.create(createRequest), HttpStatus.CREATED);
    }
}
