package com.ajwalker.entity;

import com.ajwalker.utility.enums.EDivision;
import com.ajwalker.utility.enums.ERegion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblleague")
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String leaugeName;

    @Enumerated(EnumType.STRING)
    private ERegion region;
    @Enumerated(EnumType.STRING)
    private EDivision division;

    @ManyToOne
    private Season season;
    private String deneme;
}
