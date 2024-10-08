package com.riwi.superSchool.model;

import com.riwi.superSchool.enums.Difficulty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "mission")
public class MissionEntity extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Difficulty difficulty;

    @ManyToOne
    @JoinColumn(name = "ability_id", nullable = false)
    private AbilityEntity necessaryAbilities;
}
