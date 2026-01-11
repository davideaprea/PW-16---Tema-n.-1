package com.business.group.schedule.exception;

import com.business.group.schedule.dto.DailyTimeSlot;
import lombok.Getter;

import java.util.List;

@Getter
public class ConflictingTimeSlotException extends RuntimeException {
    private final static String messageTemplate = "The inserted time slot %s is conflicting with these existing schedules: %s";

    private final DailyTimeSlot conflictingTimeSlot;
    private final List<? extends DailyTimeSlot> existingTimeSlots;

    public ConflictingTimeSlotException(
            DailyTimeSlot conflictingTimeSlot,
            List<? extends DailyTimeSlot> existingTimeSlots
    ) {
        super(messageTemplate.formatted(conflictingTimeSlot, existingTimeSlots));
        this.conflictingTimeSlot = conflictingTimeSlot;
        this.existingTimeSlots = List.copyOf(existingTimeSlots);
    }
}
