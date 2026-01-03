package com.business.group.organization.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.time.Year;
import java.util.List;

@Entity
@Table(
        name = "centre_calendars",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_medical_centre_year",
                        columnNames = {"medical_centre_id", "year"}
                )
        }
)
@NoArgsConstructor
@Getter
@Setter
@Immutable
@AllArgsConstructor
public class MedicalCentreCalendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long medicalCentreId;

    @Column(nullable = false)
    private Year year;

    @OneToMany(
            mappedBy = "calendar",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OpeningDay> openingDays;

    @OneToMany(
            mappedBy = "calendar",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ClosingPeriod> closingPeriods;
}
