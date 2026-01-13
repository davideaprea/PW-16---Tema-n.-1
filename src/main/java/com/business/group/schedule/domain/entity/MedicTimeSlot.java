package com.business.group.schedule.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "medics_time_slots")
@NoArgsConstructor
@Getter
@Setter
@Immutable
@AllArgsConstructor
public class MedicTimeSlot extends TimeSlot {
    @Column(nullable = false)
    private Long roomId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MedicCalendar medicCalendar;
}
