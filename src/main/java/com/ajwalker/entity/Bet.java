package com.ajwalker.entity;

import com.ajwalker.utility.enums.EBetState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblbet")
public class Bet extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double totaBetOdd;
    private Double betAmount;

    @Enumerated(EnumType.STRING)
    private EBetState betState;


    @OneToMany
    private List<BetOdds> betOdds = new ArrayList<>();


}
