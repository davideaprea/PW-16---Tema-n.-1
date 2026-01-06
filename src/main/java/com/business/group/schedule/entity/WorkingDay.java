package com.business.group.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;

@Setter
@Getter
@MappedSuperclass
public abstract class WorkingDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected DayOfWeek dayOfWeek;
}
