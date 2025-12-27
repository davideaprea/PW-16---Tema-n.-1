package com.business.medicalcentre.medicalcentre.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Table
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

    private String notes;

    @ManyToOne(optional = false)
    private City city;
}
