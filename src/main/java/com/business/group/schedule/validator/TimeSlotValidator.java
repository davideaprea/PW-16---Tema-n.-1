package com.business.group.schedule.validator;

import com.business.group.schedule.dto.DailyTimeSlot;
import com.business.group.schedule.exception.InvalidTimeRangeException;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class TimeSlotValidator {
    public void checkValidity(DailyTimeSlot dailyTimeSlot) {
        if(dailyTimeSlot.from().isAfter(dailyTimeSlot.to())) {
            throw new InvalidTimeRangeException(dailyTimeSlot.from(), dailyTimeSlot.to());
        }
    }

    public void checkForOverlappingSlots(List<? extends DailyTimeSlot> dailyTimeSlots) {
        dailyTimeSlots.sort(Comparator
                .comparing(DailyTimeSlot::dayOfWeek)
                .thenComparing(DailyTimeSlot::from)
        );

        for (int i = 1; i < dailyTimeSlots.size(); i++) {
            final DailyTimeSlot curr = dailyTimeSlots.get(i);
            final DailyTimeSlot prev = dailyTimeSlots.get(i - 1);

            if (
                    curr.dayOfWeek().equals(prev.dayOfWeek()) &&
                    curr.from().isBefore(prev.to())
            ) {
                //throw
            }
        }
    }
}
