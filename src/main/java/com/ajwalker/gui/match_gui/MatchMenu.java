package com.ajwalker.gui.match_gui;

import com.ajwalker.entity.League;
import com.ajwalker.entity.Manager;
import com.ajwalker.entity.Match;
import com.ajwalker.entity.Season;
import com.ajwalker.gui.league_gui.DetailedLeagueMenu;
import com.ajwalker.gui.league_gui.LeagueMenu;
import com.ajwalker.gui.manager_gui.ManagerLoginRegister;
import com.ajwalker.model.LeagueModel;
import com.ajwalker.service.MatchService;
import com.ajwalker.service.SeasonService;
import com.ajwalker.utility.ConsoleTextUtils;

import java.time.LocalDate;
import java.util.Optional;

import static com.ajwalker.utility.ConsoleTextUtils.*;

public class MatchMenu {
	private Optional<Manager> manager;
	private League league;
	private LocalDate currentDate;
	private static MatchMenu instance;
	MatchService matchService = MatchService.getInstance();
	
	private MatchMenu() {
	}
	
	public static MatchMenu getInstance() {
		if (instance == null) {
			instance = new MatchMenu();
		}
		return instance;
	}
	
	
	public void matchMenu(Optional<Manager> manager) {
		this.manager = manager;
		boolean opt = true;
		this.league = LeagueMenu.getInstance().selectLeague();
		if (this.league == null) {
			System.out.println("No such league found!");
		}
		else {
			do {
				this.currentDate = this.league.getSeason().getCurrentDate();
				if (!this.manager.isEmpty()) opt = matchInfoMenu();
				else this.manager = ManagerLoginRegister.getInstance().loginRegisterMenu();
				
			} while (opt);
		}
	}
	
	private boolean matchInfoMenu() {
		printTitle("Match Menu");
		printMenuOptions("Play a Match", "Play Several Match", "Show Played Matches", "Show Standings", "Return To " +
				"Main Menu");
		LocalDate currentDate = league.getSeason().getCurrentDate();
		printSuccessMessage("Current date: " + currentDate.toString());
		return matchInfoMenuOptions(getIntUserInput("Select: "));
	}
	
	private boolean matchInfoMenuOptions(int userInput) {
		switch (userInput) {
			case 1:
				playMatch();
				break;
			case 2:
				getDaysToAdvanceFromUser();
				
				break;
			
			case 3:
				break;
			
			
			case 4:
				new LeagueModel(league).displayStandings();
				break;
			
			case 5:
				System.out.println("Returning to Main Menu");
				return false;
		}
		return true;
	}
	
	
	public void playMatch() {
		Match match = matchService.playMatch();
		SeasonService.getInstance().updateCurrentDate(league.getSeason(), match);
	}
	
	public void getDaysToAdvanceFromUser(){
		
		matchService.advanceDateByDays(league);
		
		
	}
	
	
}