package com.ajwalker.entity;

import com.ajwalker.utility.enums.EOfferResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblcontractoffer")
public class ContractOffer extends BaseEntity{ //Oyuncu sözleşmesi için
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long offeredSalary;
    private EOfferResponse response;


   @OneToOne
    private TransferOffer transferOffer;
}
