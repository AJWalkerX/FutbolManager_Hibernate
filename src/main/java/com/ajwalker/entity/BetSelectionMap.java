package com.ajwalker.entity;

import com.ajwalker.utility.enums.EOddSelection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblbet_selection_map")
public class BetSelectionMap extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bet_id;
    private Long betOdds_id;
    private EOddSelection oddSelection;
    private BigDecimal betOdd;
}
