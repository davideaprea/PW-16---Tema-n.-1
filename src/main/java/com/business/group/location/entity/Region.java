package com.business.group.location.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Table(name = "regions")
@NoArgsConstructor
@Getter
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String name;
}
