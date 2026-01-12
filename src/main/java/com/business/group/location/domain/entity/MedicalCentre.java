package com.business.group.location.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;

import java.util.List;

@Entity
@Table(name = "medical_centres")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicalCentre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(
            optional = false,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Address address;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 16)
    private String phone;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            mappedBy = "medicalCentre"
    )
    private List<Floor> floors;
}
