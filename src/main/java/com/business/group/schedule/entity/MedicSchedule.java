package com.business.group.schedule.entity;

import com.business.group.shared.time.Range;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.time.LocalTime;

@Immutable
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "medic_schedules",
        indexes = {
                @Index(name = "idx_room_id", columnList = "room_id")
        }
)
public class MedicSchedule implements Range<LocalTime> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long medicId;

    @Column(nullable = false)
    private Long roomId;

    @Column(nullable = false)
    private LocalTime from;

    @Column(nullable = false)
    private LocalTime to;

    @Override
    public LocalTime from() {
        return from;
    }

    @Override
    public LocalTime to() {
        return to;
    }
}
