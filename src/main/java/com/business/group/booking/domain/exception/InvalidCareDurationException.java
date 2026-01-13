package com.business.group.booking.domain.exception;

import lombok.Getter;

import java.time.LocalTime;

@Getter
public class InvalidCareDurationException extends RuntimeException {
  private final LocalTime slotStartTime;
  private final LocalTime slotEndTime;
  private final LocalTime careStartTime;
  private final LocalTime careEndTime;

    public InvalidCareDurationException(
            LocalTime slotStartTime,
            LocalTime slotEndTime,
            LocalTime careStartTime,
            LocalTime careEndTime
    ) {
        super("Care duration doesn't match with slot time range. Time slot range: %s - %s. Care time range: %s - %s".formatted(
                slotStartTime, slotEndTime, careStartTime, careEndTime
        ));
        this.slotStartTime = slotStartTime;
        this.slotEndTime = slotEndTime;
        this.careStartTime = careStartTime;
        this.careEndTime = careEndTime;
    }
}
