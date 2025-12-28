package com.business.medicalcentre.medicalcentre.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;
import jakarta.persistence.Id;

@Entity
@Table(
        name = "medical_centre_floors",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_medical_centre_floor",
                        columnNames = {"medical_centre_id", "number"}
                )
        }
)
@Getter
@AllArgsConstructor
@Immutable
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MedicalCentre medicalCentre;

    @Column(nullable = false)
    private Integer number;
}
