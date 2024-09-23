package com.ajwalker.controller;

import com.ajwalker.entity.Match;
import com.ajwalker.service.MatchService;

public class MatchController{
	private static MatchController instance;
	private MatchController() {
	
	}
	public static MatchController getInstance() {
		if (instance == null) {
			instance = new MatchController();
		}
		return instance;
	}
}