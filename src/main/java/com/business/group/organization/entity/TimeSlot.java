package com.business.group.organization.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "centre_time_slots")
@NoArgsConstructor
@Getter
@Setter
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalTime from;

    @Column(nullable = false)
    private LocalTime to;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private OpeningDay openingDay;
}
