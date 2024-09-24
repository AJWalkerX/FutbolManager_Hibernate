package com.ajwalker.controller;

import com.ajwalker.entity.Manager;
import com.ajwalker.entity.TransferOffer;
import com.ajwalker.service.TransferOfferService;
import com.ajwalker.utility.HibernateConnection;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.HibernateError;

import java.util.List;
import java.util.Optional;

public class TransferOfferController {
    private static TransferOfferController instance;
    private static TransferOfferService transferOfferService = TransferOfferService.getInstance();

    private TransferOfferController() {

    }
    public static TransferOfferController getInstance() {
        if (instance == null) {
            instance =new TransferOfferController();
        }
        return instance;
    }

    public TransferOffer save (TransferOffer transferOffer) {
        return transferOfferService.save(transferOffer);
    }


    public List<TransferOffer> displayOffersForReceiver(Manager manager) {
        String hql = "from TransferOffer where receiver = :receiver";
        return HibernateConnection.em.createQuery(hql, TransferOffer.class)
                .setParameter("receiver", manager.getTeam())
                .getResultList();
    }
}
