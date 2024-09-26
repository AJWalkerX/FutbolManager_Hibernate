package com.ajwalker.service;

import com.ajwalker.entity.Manager;
import com.ajwalker.entity.Player;
import com.ajwalker.entity.Team;
import com.ajwalker.entity.TransferOffer;
import com.ajwalker.repository.TransferOfferRepository;
import com.ajwalker.utility.ConsoleTextUtils;
import com.ajwalker.utility.enums.EOfferResponse;

import java.util.ArrayList;
import java.util.List;

public class TransferOfferService extends ServiceManager<TransferOffer,Long> {

    private static TransferOfferService instance;
    private static TransferOfferRepository transferOfferRepository = TransferOfferRepository.getInstance();
    private static PlayerService playerService = PlayerService.getInstance();
    private static TeamService teamService = TeamService.getInstance();

    private TransferOfferService() {
        super(TransferOfferRepository.getInstance());

    }
    public static TransferOfferService getInstance() {
        if (instance == null) {
            instance = new TransferOfferService();

        }
        return instance;
    }

    public List<TransferOffer> getOffersForReceiver(Manager manager) {
        try {
            return transferOfferRepository.getOffersForReceiver(manager);
        } catch (Exception e) {
            ConsoleTextUtils.printErrorMessage("Service Error: "+ e.getMessage());
            return new ArrayList<>();
        }
    }

    public void replyToOffer(TransferOffer transferOffer, int userReplySelection) {
        Player player = transferOffer.getPlayer();
        Team proposer = transferOffer.getProposer();
        Team receiver = transferOffer.getReceiver();
        Long biddingMoney = transferOffer.getBiddingMoney();

        try {
            if (userReplySelection == 1) {
                //TODO: Sözleşme görüşme aşaması eklenecek!!!
                transferOffer.setResponse(EOfferResponse.ACCEPTED);
                player.setTeam(proposer);
                receiver.setBudget(receiver.getBudget()+biddingMoney);
                proposer.setBudget(proposer.getBudget()-biddingMoney);
                System.out.println("Transfer Accepted. Now "+ player.getName()+ " is leaving your team");
                proposer.getPlayers().add(player);
                receiver.getPlayers().remove(player);
                teamService.updateAll(List.of(proposer,receiver));
                playerService.update(player);
                transferOfferRepository.update(transferOffer);
            } else if (userReplySelection == 2) {
                transferOffer.setResponse(EOfferResponse.REJECTED);
                transferOfferRepository.update(transferOffer);
                System.out.println("You have rejected this offer!");
            }else{
                ConsoleTextUtils.printErrorMessage("Wrong selection!");
            }
        } catch (Exception e) {
            ConsoleTextUtils.printErrorMessage("Service Error: "+ e.getMessage());
        }


    }
}
