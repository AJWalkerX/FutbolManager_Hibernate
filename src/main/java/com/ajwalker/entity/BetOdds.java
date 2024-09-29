package com.ajwalker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblbet_odds")
public class BetOdds extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double homeTeamWins;
    private Double awayTeamWins;
    private Double draw;
    private Double totalGoalsEqual3OrMore;
    private Double totalGoalsEqual2OrLess;

    @OneToOne
    private Match match;

}
