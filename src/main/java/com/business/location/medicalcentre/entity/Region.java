package com.business.location.medicalcentre.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Table(name = "regions")
@NoArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String name;
}
