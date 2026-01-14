package com.business.group.booking.http.controller;

import com.business.group.booking.http.dto.BookingCreateRequest;
import com.business.group.booking.http.dto.BookingDTO;
import com.business.group.shared.http.doc.ConflictingResourceResponseDoc;
import com.business.group.shared.http.doc.InvalidPayloadResponseDoc;
import com.business.group.shared.http.doc.ResourceCreatedResponse;
import org.springframework.http.ResponseEntity;

public interface BookingControllerDocs {
    @ResourceCreatedResponse(BookingDTO.class)
    @ConflictingResourceResponseDoc("If the selected time slot is already booked.")
    @InvalidPayloadResponseDoc("If the booking date doesn't match with the medic time slot.")
    ResponseEntity<BookingDTO> create(BookingCreateRequest createRequest);
}
