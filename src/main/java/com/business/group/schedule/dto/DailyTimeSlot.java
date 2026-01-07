package com.business.group.schedule.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

public interface DailyTimeSlot {
    LocalTime from();

    LocalTime to();

    DayOfWeek dayOfWeek();
}
