package com.ajwalker.controller;


import com.ajwalker.entity.League;
import com.ajwalker.service.LeagueService;

public class LeagueController {
	private static LeagueController instance;
	private LeagueController() {
	
	}
	public static LeagueController getInstance() {
		if (instance == null) {
			instance = new LeagueController();
		}
			return instance;
	}
}