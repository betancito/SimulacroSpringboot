package com.riwi.superSchool.entities;

import com.riwi.superSchool.enums.RegisteredAction;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class Auditable {
    @Column(nullable = false, updatable = false)
    private Long createdBy;

    @Column(nullable = false)
    private Long updatedBy;

    @Column(nullable = false)
    private RegisteredAction action;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

}
