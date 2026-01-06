package com.business.group.schedule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.util.List;

@Entity
@Table(name = "medics_working_days")
@NoArgsConstructor
@Getter
@Setter
@Immutable
@AllArgsConstructor
public class MedicWorkingDay extends WorkingDay {
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MedicCalendar calendar;

    @OneToMany(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY,
            mappedBy = "workingDay"
    )
    private List<MedicTimeSlot> timeSlots;
}
