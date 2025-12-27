package com.business.medicalcentre.medicalcentre.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import jakarta.persistence.Id;

@Entity
@Table(
        name = "cities",
        indexes = {
                @Index(
                        name = "idx_city_region",
                        columnList = "region_id"
                )
        }
)
@AllArgsConstructor
@Getter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 40)
    private String name;

    @Column(nullable = false, unique = true, length = 5)
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private City province;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Region region;
}
