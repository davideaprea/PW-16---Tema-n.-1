package com.business.group.schedule.domain.exception;

import lombok.Getter;

import java.time.LocalTime;

@Getter
public class InvalidTimeRangeException extends RuntimeException {
    private final LocalTime from;
    private final LocalTime to;

    public InvalidTimeRangeException(LocalTime from, LocalTime to) {
        super("'From' property with value %s is greater than the 'to' property with value %s."
                .formatted(from, to));
        this.from = from;
        this.to = to;
    }
}
