package com.business.group.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.util.List;

@Entity
@Table(
        name = "centre_working_days",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_calendar_day_of_week",
                        columnNames = {"calendar_id", "day_of_week"}
                )
        }
)
@NoArgsConstructor
@Getter
@Setter
@Immutable
public class CentreWorkingDay extends WorkingDay {
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CentreCalendar calendar;

    @OneToMany(
            mappedBy = "openingDay",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CentreTimeSlot> centreTimeSlots;
}
