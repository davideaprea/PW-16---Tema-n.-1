package com.business.group.healthcare.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "medics_services")
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
