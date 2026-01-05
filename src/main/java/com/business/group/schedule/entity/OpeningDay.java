package com.business.group.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.time.DayOfWeek;
import java.util.List;

@Entity
@Table(
        name = "centre_opening_days",
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
public class OpeningDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MedicalCentreCalendar calendar;

    @OneToMany(
            mappedBy = "openingDay",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TimeSlot> timeSlots;
}
