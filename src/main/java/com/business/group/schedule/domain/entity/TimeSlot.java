package com.business.group.schedule.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Setter
@Getter
@MappedSuperclass
public abstract class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected LocalTime from;

    @Column(nullable = false)
    protected LocalTime to;

    @Column(nullable = false)
    protected DayOfWeek dayOfWeek;
}
