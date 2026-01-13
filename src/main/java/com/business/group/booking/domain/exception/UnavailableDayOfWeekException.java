package com.business.group.booking.domain.exception;

import com.business.group.booking.http.dto.BookingCreateRequest;
import com.business.group.shared.exception.InvalidParamError;
import com.business.group.shared.exception.InvalidParamException;
import lombok.Getter;

import java.time.DayOfWeek;
import java.util.List;

@Getter
public class UnavailableDayOfWeekException extends InvalidParamException {
    public UnavailableDayOfWeekException(DayOfWeek slotDayOfWeek) {
        super(new InvalidParamError(
                BookingCreateRequest.Fields.expectedStartTime,
                "The selected slot is scheduled for %s only.".formatted(slotDayOfWeek),
                List.of(slotDayOfWeek.toString())
        ));
    }
}
