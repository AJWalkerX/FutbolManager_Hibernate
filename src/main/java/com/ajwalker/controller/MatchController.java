package com.ajwalker.controller;

import com.ajwalker.entity.Match;
import com.ajwalker.service.MatchService;

public class MatchController extends ControllerManager<Match,Long>{
	private static MatchController instance;
	private MatchController() {
		super(MatchService.getInstance());
	}
	public static MatchController getInstance() {
		if (instance == null) {
			instance = new MatchController();
		}
		return instance;
	}
}