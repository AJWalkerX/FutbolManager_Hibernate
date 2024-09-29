package com.ajwalker.entity;

import com.ajwalker.utility.enums.EBetState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
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
    @Column(precision = 10, scale = 2)
    private BigDecimal totalBetOdd;
    @Column(precision = 10, scale = 2)
    private BigDecimal betAmount;

    @Enumerated(EnumType.STRING)
    private EBetState betState = EBetState.ON_WAIT;


    @OneToMany
    private List<BetOdds> betOdds = new ArrayList<>();


}
