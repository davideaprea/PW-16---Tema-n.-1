package com.business.medicalcentre.medicalcentre.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import jakarta.persistence.Id;

@Entity
@Table(name = "medical_centres")
@AllArgsConstructor
@Getter
public class MedicalCentre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;
}
