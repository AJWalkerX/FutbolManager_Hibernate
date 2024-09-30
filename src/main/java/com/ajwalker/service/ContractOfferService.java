package com.ajwalker.service;

import com.ajwalker.entity.ContractOffer;
import com.ajwalker.entity.Player;
import com.ajwalker.entity.TransferOffer;
import com.ajwalker.repository.ContractOfferRepository;
import com.ajwalker.repository.ICRUD;
import com.ajwalker.utility.enums.EOfferResponse;

public class ContractOfferService extends ServiceManager<ContractOffer,Long> {
    private static ContractOfferService instance;
    private ContractOfferRepository contractOfferRepository = ContractOfferRepository.getInstance();
    private ContractOfferService() {
        super(ContractOfferRepository.getInstance());
    }
    public static ContractOfferService getInstance() {
        if (instance == null) {
            instance = new ContractOfferService();
        }
        return instance;
    }
    public ContractOffer makeOfferToPlayer(TransferOffer transferOffer,Long salaryOffer) {
        ContractOffer contractOffer = ContractOffer.builder()
                .offeredSalary(salaryOffer)
                .transferOffer(transferOffer)
                .build();
        Player player = transferOffer.getPlayer();
        if(salaryOffer>=player.getSalary()){
            contractOffer.setResponse(EOfferResponse.ACCEPTED);
        }
        else{
            contractOffer.setResponse(EOfferResponse.REJECTED);
            System.out.println("Player has rejected your offer.");
        }
        contractOfferRepository.save(contractOffer);
        return contractOffer;
    }

}
