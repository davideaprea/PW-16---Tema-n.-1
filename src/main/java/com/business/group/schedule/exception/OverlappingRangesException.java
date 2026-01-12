package com.business.group.schedule.exception;

import com.business.group.schedule.dto.DailyTimeSlot;
import lombok.Getter;

import java.util.List;

@Getter
public class OverlappingRangesException extends RuntimeException {
    private final List<DailyTimeSlot> conflictingRanges;

    public OverlappingRangesException(List<DailyTimeSlot> conflictingRanges) {
        super("These ranges are overlapping: %s".formatted(conflictingRanges));
        this.conflictingRanges = List.copyOf(conflictingRanges);
    }
}
