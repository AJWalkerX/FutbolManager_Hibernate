package com.ajwalker.gui.manager_gui;

import com.ajwalker.controller.ManagerController;
import com.ajwalker.controller.PlayerController;
import com.ajwalker.controller.TransferOfferController;
import com.ajwalker.entity.Manager;
import com.ajwalker.entity.Player;
import com.ajwalker.entity.TransferOffer;
import com.ajwalker.model.OffersModel;
import com.ajwalker.model.PlayerModel;
import com.ajwalker.utility.ConsoleTextUtils;
import com.ajwalker.utility.enums.EOfferResponse;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static com.ajwalker.utility.ConsoleTextUtils.*;

public class ManagePlayers {
    private Manager manager;
    ManagerController managerController = ManagerController.getInstance();
    PlayerController playerController = PlayerController.getInstance();
    TransferOfferController transferOfferController = TransferOfferController.getInstance();

    private final int starSize = 50;


    public Optional<Manager> managePlayers(Optional<Manager> manager) {
        AtomicBoolean opt = new AtomicBoolean(false);
        manager.ifPresentOrElse(m -> {
            this.manager = m;
            do {
                opt.set(managePlayersMenu());
            } while (opt.get());
        }, () -> this.manager = null);

        return Optional.ofNullable(this.manager);
    }


    private boolean managePlayersMenu() {
        printTitle(starSize, "Manage Players Menu");
        printMenuOptions(starSize,
                "Make an offer for player",
                "Display offers for my team",
                "Display my previous offers",
                "Return To Dashboard");
        return managePlayersMenuOptions(getIntUserInput("Select: "));
    }

    private boolean managePlayersMenuOptions(int intUserInput) {
        List<TransferOffer> recievedOffers = transferOfferController.getOffersForReceiver(manager);
        switch (intUserInput) {
            case 1: {
                Player player = searchPlayer();
                if (player != null) {
                    makeAnOfferForPlayer(player);
                }

                break;
            }
            case 2: {
                List<TransferOffer> onWaitList =
                        recievedOffers.stream().filter(offer -> offer.getResponse().equals(EOfferResponse.ON_WAIT)).toList();
                displayOffers(onWaitList);
                if (!onWaitList.isEmpty()) {
                    Optional<TransferOffer> transferOffer = selectRecieved(onWaitList);
                    transferOffer.ifPresent(this::replyOffer);
                }
				else{
					System.out.println("No received offers");
				}
                break;
            }
            case 3: {
                List<TransferOffer> previousOffers =
                        recievedOffers.stream().filter(offer ->
                                        offer.getResponse().equals(EOfferResponse.ACCEPTED) ||
                                                offer.getResponse().equals(EOfferResponse.REJECTED))
                                .toList();
                displayOffers(previousOffers);
                if (!recievedOffers.isEmpty()) {
                    selectRecieved(previousOffers);
                }
                break;
            }
            case 4: {// Exit..
                return false;
            }
        }
        return true;
    }

    private void displayOffers(List<TransferOffer> offerList) {
        if (!offerList.isEmpty()) {
            int counter = 1;
            for (TransferOffer offers : offerList) {
                System.out.println(counter + "- " + offers.getMessage() + " From: " + offers.getProposer().getTeamName());
                counter++;
            }
            System.out.println();
        }
    }

    private void replyOffer(TransferOffer transferOffer) {
        printMenuOptions("Reply", "Return To Dashboard");
        int userSelection = getIntUserInput("Select: ");
        switch (userSelection) {
            case 1: {
                printMenuOptions("Accept Offer", "Reject Offer");
                int userReplySelection = getIntUserInput("Select Reply: ");

                transferOfferController.replyToOffer(transferOffer, userReplySelection);

                break;
            }
        }
    }

    private Optional<TransferOffer> selectRecieved(List<TransferOffer> recievedOffers) {
        printMenuOptions("Select Offer", "Return To Dashboard");
        int userSelection = getIntUserInput("Select: ");
        switch (userSelection) {
            case 1: {
                int userInput = getIntUserInput("Select Offer: ");
                if (userInput <= 0 || userInput - 1 > recievedOffers.size() - 1) {
                    System.out.println("Invalid Selection");
                } else {
                    TransferOffer transferOfferMassage = recievedOffers.get(userInput - 1);
                    new OffersModel(transferOfferMassage).displayRecievedOffer();
                    return Optional.of(transferOfferMassage);
                }
            }
        }
        return Optional.empty();
    }


    private void makeAnOfferForPlayer(Player player) {
        new PlayerModel(player).displayPlayerForOffer();
        printMenuOptions("Make An Offer For Player", "Return");
        int choice = getIntUserInput("Your choice: ");
        switch (choice) {
            case 1:
                // DTO Olsayadı bu kodlar service'de olacaktı!
                TransferOffer transferOffer = new TransferOffer();
                transferOffer.setPlayer(player);
                transferOffer.setMessage(getStringUserInput("Message: "));
                transferOffer.setReceiver(player.getTeam());
                transferOffer.setProposer(manager.getTeam());
                transferOffer.setResponse(EOfferResponse.ON_WAIT);
                transferOffer.setBiddingMoney(ConsoleTextUtils.getLongInput("State your offer"));
                transferOfferController.save(transferOffer);
                break;
            case 2: {
                break;
            }

        }

    }

    private Player searchPlayer() {
        String nameToSearch = getStringUserInput("Search player: ");
        List<Player> playerList = playerController.makeAnOfferForPlayer(nameToSearch);
        if (!playerList.isEmpty()) {
            AtomicInteger sayac = new AtomicInteger(1);
            playerList.stream().forEach(p -> {
                System.out.println(sayac.getAndIncrement() + " - " + p.getName() + "\t\t" + p.getSkillLevel() + "\t" + p.getPosition());
            });
            int intUserInput = getIntUserInput("Pick a player to offer: ");
            return playerList.get(intUserInput - 1);
        }
        return null;
    }
}