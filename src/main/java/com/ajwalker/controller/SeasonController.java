package com.ajwalker.controller;

import com.ajwalker.entity.Season;
import com.ajwalker.service.SeasonService;

public class SeasonController {
	private static SeasonController instance;
	public SeasonController() {
	
	}
	public static SeasonController getInstance() {
		if (instance == null) {
			instance = new SeasonController();
		}
		return instance;
	}
}