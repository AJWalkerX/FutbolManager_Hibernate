package com.ajwalker.gui.manager_gui;

import com.ajwalker.controller.ManagerController;
import com.ajwalker.entity.Manager;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.ajwalker.utility.ConsoleTextUtils.*;
import static com.ajwalker.utility.ConsoleTextUtils.printSuccessMessage;

public class ManagePlayers {
	private Manager manager;
	ManagerController managerController = ManagerController.getInstance();
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
		                 "Make An Offer For Player",
		                 "Display Offers For My Team",
		                 "Return To Dashboard");
		return managePlayersMenuOptions(getIntUserInput("Select: "));
	}
	
	private boolean managePlayersMenuOptions(int intUserInput) {
		switch (intUserInput) {
			case 1:{
			
				break;
			}
			case 2:{
				break;
			}
			
			case 3:{// Exit..
				return false;
			}
		}
		return true;
	}
}