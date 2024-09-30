package com.ajwalker.repository;

import com.ajwalker.entity.ContractOffer;

public class ContractOfferRepository extends RepositoryManager<ContractOffer,Long> {
    private static ContractOfferRepository instance;
    private ContractOfferRepository() {
        super(ContractOffer.class);
    }
    public static ContractOfferRepository getInstance() {
        if (instance == null) {
            instance = new ContractOfferRepository();
        }
        return instance;
    }


}
