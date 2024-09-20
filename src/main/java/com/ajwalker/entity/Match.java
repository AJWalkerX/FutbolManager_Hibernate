package com.ajwalker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblmatch")
public class Match extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    static Integer matchIdCounter = 0;
    private Integer homeTeamId;
    private Integer awayTeamId;
    private int homeTeamScore;
    private int awayTeamScore;
    private LocalDate matchDate;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Fixture fixture;
}