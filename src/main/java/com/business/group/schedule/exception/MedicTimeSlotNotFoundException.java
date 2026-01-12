package com.business.group.schedule.exception;

public class MedicTimeSlotNotFoundException extends RuntimeException {
    public MedicTimeSlotNotFoundException(long id) {
        super("Couldn't find any medic time slot with this id: %d".formatted(id));
    }
}
