package com.business.group.booking.exception;

import lombok.Getter;

import java.time.DayOfWeek;

@Getter
public class UnavailableDayOfWeekException extends RuntimeException {
    private final DayOfWeek selectedDayOfWeek;
    private final DayOfWeek timeSlotDayOfWeek;

    public UnavailableDayOfWeekException(DayOfWeek selectedDayOfWeek, DayOfWeek timeSlotDayOfWeek) {
        super("Selected day %s does not match slot day %s.".formatted(selectedDayOfWeek, timeSlotDayOfWeek));
        this.selectedDayOfWeek = selectedDayOfWeek;
        this.timeSlotDayOfWeek = timeSlotDayOfWeek;
    }
}
