package com.business.group.schedule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.util.List;

@Entity
@Table(name = "centre_calendars")
@NoArgsConstructor
@Getter
@Setter
@Immutable
@AllArgsConstructor
public class CentreCalendar extends Calendar {
    @OneToMany(
            mappedBy = "calendar",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CentreTimeSlot> timeSlots;

    @OneToMany(
            mappedBy = "calendar",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CentreClosingPeriod> centreClosingPeriods;
}
