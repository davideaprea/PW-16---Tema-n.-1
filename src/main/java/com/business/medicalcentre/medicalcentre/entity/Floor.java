package com.business.medicalcentre.medicalcentre.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;
import jakarta.persistence.Id;

@Entity
@Table
@Getter
@AllArgsConstructor
@Immutable
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private MedicalCentre medicalCentre;

    @Column(nullable = false)
    private Integer number;
}
