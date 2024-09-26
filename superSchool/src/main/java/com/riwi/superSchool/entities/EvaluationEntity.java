package com.riwi.superSchool.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EvaluationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column
    @ManyToOne(optional = false)
    private MissionEntity missionEntity;

    @Column
    @ManyToOne(optional = false)
    private UserEntity userEntity;

    @Column
    private Integer grade;

    @Column
    private String additionalComments;
}
