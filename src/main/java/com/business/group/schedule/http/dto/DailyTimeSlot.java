package com.business.group.schedule.http.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

public interface DailyTimeSlot {
    LocalTime from();

    LocalTime to();

    DayOfWeek dayOfWeek();
}
