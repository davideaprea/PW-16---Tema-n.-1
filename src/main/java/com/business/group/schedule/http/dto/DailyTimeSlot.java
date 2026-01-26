package com.business.group.schedule.http.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

public interface DailyTimeSlot {
    LocalTime startTime();

    LocalTime endTime();

    DayOfWeek dayOfWeek();
}
