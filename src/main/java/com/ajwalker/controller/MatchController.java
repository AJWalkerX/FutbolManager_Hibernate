package com.ajwalker.controller;

import com.ajwalker.entity.Fixture;
import com.ajwalker.entity.Match;
import com.ajwalker.service.MatchService;

import java.util.List;

public class MatchController{
	private static MatchController instance;
	MatchService matchService = MatchService.getInstance();
	private MatchController() {
	
	}
	public static MatchController getInstance() {
		if (instance == null) {
			instance = new MatchController();
		}
		return instance;
	}
	public List<Match> findMatchesByFixture(Fixture fixture) {
		return  matchService.findMatchesByFixture(fixture);
		
	}
}