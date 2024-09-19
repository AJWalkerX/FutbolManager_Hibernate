package com.ajwalker.controller;


import com.ajwalker.entity.League;
import com.ajwalker.service.LeagueService;

public class LeagueController extends ControllerManager<League,Long>{
	private static LeagueController instance;
	private LeagueController() {
		super(LeagueService.getInstance());
	}
	public static LeagueController getInstance() {
		if (instance == null) {
			instance = new LeagueController();
		}
			return instance;
	}
}