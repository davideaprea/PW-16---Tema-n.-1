package com.business.group.schedule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.util.List;

@Entity
@Table(
        name = "medics_calendars"
)
@NoArgsConstructor
@Getter
@Setter
@Immutable
@AllArgsConstructor
public class MedicCalendar extends Calendar {
    @OneToMany(
            mappedBy = "calendar",
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST
    )
    private List<MedicTimeSlot> timeSlots;
}
