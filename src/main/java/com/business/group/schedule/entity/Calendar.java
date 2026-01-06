package com.business.group.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
public abstract class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected Long ownerId;

    @CreatedDate
    @Column(nullable = false)
    protected LocalDateTime createdAt;

    @Column(nullable = false)
    protected LocalDateTime validFrom;

    protected LocalDateTime validTo;

    @Column(length = 500)
    protected String notes;
}
