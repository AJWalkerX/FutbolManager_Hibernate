package com.ajwalker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblcontractoffer")
public class ContractOffer { //Oyuncu sözleşmesi için
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long offeredSalary;


    @OneToOne
    private Player player;
    @OneToOne
    private Team proposingTeam;
}
