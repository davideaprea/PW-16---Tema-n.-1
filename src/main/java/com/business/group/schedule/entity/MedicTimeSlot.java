package com.business.group.schedule.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    @ManyToOne(
            optional = false,
            fetch = FetchType.LAZY
    )
    private MedicWorkingDay workingDay;

    private Long roomId;
}
