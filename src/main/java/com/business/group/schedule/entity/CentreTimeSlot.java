package com.business.group.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "centre_time_slots")
@NoArgsConstructor
@Getter
@Setter
@Immutable
public class CentreTimeSlot extends TimeSlot {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CentreCalendar calendar;
}
