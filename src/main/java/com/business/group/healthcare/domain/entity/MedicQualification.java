package com.business.group.healthcare.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "medics_qualification",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_medic_care",
                        columnNames = {"medic_id", "medical_care_id"}
                )
        }
)
@Immutable
public class MedicQualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long medicId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MedicalCare medicalCare;
}
