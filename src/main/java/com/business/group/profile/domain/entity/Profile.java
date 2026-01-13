package com.business.group.profile.domain.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@MappedSuperclass
public abstract class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDate createdAt;

    @Column(updatable = false, unique = true)
    private Long userId;
}
