package com.ajwalker.entity;

import com.ajwalker.utility.enums.EDivision;
import com.ajwalker.utility.enums.ERegion;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblleague")
public class League extends BaseEntity {
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
}
