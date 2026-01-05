package com.business.group.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Entity
@Table(name = "centre_closing_days")
@NoArgsConstructor
@Getter
@Setter
@Immutable
public class ClosingPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime from;

    @Column(nullable = false)
    private LocalDateTime to;

    private String cause;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MedicalCentreCalendar calendar;
}
