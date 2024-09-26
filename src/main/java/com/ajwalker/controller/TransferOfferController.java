package com.ajwalker.controller;

import com.ajwalker.entity.Manager;
import com.ajwalker.entity.TransferOffer;
import com.ajwalker.service.TransferOfferService;
import com.ajwalker.utility.ConsoleTextUtils;

import java.util.ArrayList;
import java.util.List;

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


    public List<TransferOffer> getOffersForReceiver(Manager manager) {
        try {
            return transferOfferService.getOffersForReceiver(manager);
        } catch (Exception e) {
            ConsoleTextUtils.printErrorMessage("Controller Error: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public void replyToOffer(TransferOffer transferOffer, int userReplySelection) {
        try {
            transferOfferService.replyToOffer(transferOffer,userReplySelection);
        } catch (Exception e) {
            ConsoleTextUtils.printErrorMessage("Controller Error: " + e.getMessage());
        }
    }
}
