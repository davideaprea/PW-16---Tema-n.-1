package com.business.group.schedule.domain.exception;

import com.business.group.schedule.http.dto.DailyTimeSlot;
import com.business.group.shared.exception.ConflictingResourceException;

import java.util.List;

public class ConflictingTimeSlotException extends ConflictingResourceException {
    public ConflictingTimeSlotException(
            DailyTimeSlot submittedResource,
            List<? extends DailyTimeSlot> conflictingResources
    ) {
        super("This slot is already taken.", submittedResource, conflictingResources);
    }
}
