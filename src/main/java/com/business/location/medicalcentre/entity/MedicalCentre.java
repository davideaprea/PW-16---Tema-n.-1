package com.business.location.medicalcentre.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "medical_centres")
@AllArgsConstructor
@NoArgsConstructor
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

    public Iterator<Floor> getFloorsIterator() {
        if (floors == null) floors = new ArrayList<>();

        return floors.iterator();
    }
}
