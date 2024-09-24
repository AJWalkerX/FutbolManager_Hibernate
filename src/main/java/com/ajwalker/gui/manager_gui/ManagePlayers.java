package com.ajwalker.gui.manager_gui;

import com.ajwalker.controller.ManagerController;
import com.ajwalker.controller.PlayerController;
import com.ajwalker.controller.TransferOfferController;
import com.ajwalker.entity.Manager;
import com.ajwalker.entity.Player;
import com.ajwalker.entity.Team;
import com.ajwalker.entity.TransferOffer;
import com.ajwalker.model.PlayerOfferModel;
import com.ajwalker.utility.ConsoleTextUtils;
import com.ajwalker.utility.HibernateConnection;
import com.ajwalker.utility.enums.EOfferResponse;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static com.ajwalker.utility.ConsoleTextUtils.*;
import static com.ajwalker.utility.ConsoleTextUtils.printSuccessMessage;

public class ManagePlayers {
	private Manager manager;
	ManagerController managerController = ManagerController.getInstance();
	PlayerController playerController = PlayerController.getInstance();
	TransferOfferController	transferOfferController = TransferOfferController.getInstance();

	private final int starSize = 50;
	
	
	
	public Optional<Manager> managePlayers(Optional<Manager> manager) {
		AtomicBoolean opt = new AtomicBoolean(false);
		manager.ifPresentOrElse(m ->{
			this.manager = m;
			do {
				opt.set(managePlayersMenu());
			} while (opt.get());
		} , () ->  this.manager=null);
		
		return Optional.ofNullable(this.manager);
	}
	
	
	private boolean managePlayersMenu() {
		printTitle(starSize,"Manage Players Menu");
		printMenuOptions(starSize,
		                 "Make an offer for player",
		                 "Display offers for my team",
						 "Display my previous offers",
		                 "Return To Dashboard");
		return managePlayersMenuOptions(getIntUserInput("Select: "));
	}
	
	private boolean managePlayersMenuOptions(int intUserInput) {
		switch (intUserInput) {
			case 1:{
				Player player = searchPlayer();
				if(player != null) {
					makeAnOfferForPlayer(player);
				}

				break;
			}
			case 2:{
				transferOfferController.displayOffersForReceiver(manager).forEach(System.out::println);
				break;
			}
			
			case 3:{// Exit..
				return false;
			}
		}
		return true;
	}




	private void makeAnOfferForPlayer(Player player) {
		new PlayerOfferModel(player).displayPlayer();
		printMenuOptions("Make An Offer For Player","Return");
		int choice = getIntUserInput("Your choice: ");
		switch (choice){
			case 1:
				TransferOffer transferOffer = new TransferOffer();
				transferOffer.setPlayer(player);
				transferOffer.setMessage(getStringUserInput("Message: "));
				transferOffer.setReceiver(player.getTeam());
				transferOffer.setProposer(manager.getTeam());
				transferOffer.setResponse(EOfferResponse.ON_WAIT);
				transferOffer.setBiddingMoney(ConsoleTextUtils.getLongInput("State your offer"));
				transferOfferController.save(transferOffer);

		}

	}

	private Player searchPlayer() {
		String nameToSearch = getStringUserInput("Search player: ");
		List<Player> playerList = playerController.makeAnOfferForPlayer(nameToSearch);
		if(!playerList.isEmpty()){
			AtomicInteger sayac = new AtomicInteger(1);
			playerList.stream().forEach(p->{
				System.out.println(sayac.getAndIncrement()+" - "+p.getName()+"\t\t"+p.getSkillLevel()+"\t"+p.getPosition());
			});
			int intUserInput = getIntUserInput("Pick a player to offer: ");
			return playerList.get(intUserInput-1);
		}
		return null;
	}
}