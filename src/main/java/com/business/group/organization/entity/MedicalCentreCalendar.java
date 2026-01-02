package com.business.group.organization.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.time.Year;

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
public class MedicalCentreCalendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long medicalCentreId;

    @Column(nullable = false)
    private Year year;
}
