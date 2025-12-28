package com.business.medicalcentre.medicalcentre.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Table(
        name = "medical_centre_addresses",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_city_street_number",
                        columnNames = {"city_id", "name", "number"}
                ),
                @UniqueConstraint(
                        name = "uk_address_coordinates",
                        columnNames = {"latitude", "longitude"}
                )
        }
)
@AllArgsConstructor
@Getter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String number;

    @Column(precision = 9, scale = 6, nullable = false)
    private BigDecimal latitude;

    @Column(precision = 9, scale = 6, nullable = false)
    private BigDecimal longitude;

    @Column(length = 500)
    private String notes;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private City city;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private MedicalCentre medicalCentre;
}
