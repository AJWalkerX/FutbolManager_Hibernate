package com.ajwalker.service;

import com.ajwalker.entity.Manager;
import com.ajwalker.entity.TransferOffer;
import com.ajwalker.repository.TeamRepository;
import com.ajwalker.repository.TransferOfferRepository;
import com.ajwalker.utility.HibernateConnection;

import java.util.List;

public class TransferOfferService extends ServiceManager<TransferOffer,Long> {

    private static TransferOfferService instance;
    private static TransferOfferRepository transferOfferRepository = TransferOfferRepository.getInstance();

    private TransferOfferService() {
        super(TransferOfferRepository.getInstance());

    }
    public static TransferOfferService getInstance() {
        if (instance == null) {
            instance = new TransferOfferService();

        }
        return instance;
    }

    public List<TransferOffer> displayOffersForReceiver(Manager manager) {
        return transferOfferRepository.displayOffersForReceiver(manager);
    }
}
