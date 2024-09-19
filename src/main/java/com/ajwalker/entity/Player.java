package com.ajwalker.entity;

import com.ajwalker.utility.enums.EPosition;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblplayer")
public class Player extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EPosition position;
    private Integer skillLevel; //1-100 arasi olacak.
    private Long value; //degeri

    @ManyToOne
    private Team team;
}
