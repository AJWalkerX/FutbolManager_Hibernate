package com.ajwalker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblmatch")
public class Match {
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
    private Fixture fixture;
}
