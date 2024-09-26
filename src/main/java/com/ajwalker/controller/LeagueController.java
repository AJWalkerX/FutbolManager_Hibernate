package com.ajwalker.controller;


import com.ajwalker.entity.League;
import com.ajwalker.service.LeagueService;

import java.util.List;

public class LeagueController {
	private static LeagueController instance;
	private LeagueService leagueService = LeagueService.getInstance();

	private LeagueController() {
	
	}
	public static LeagueController getInstance() {
		if (instance == null) {
			instance = new LeagueController();
		}
			return instance;
	}

	public List<League> findAll(){
		return leagueService.findAll();
	}
}