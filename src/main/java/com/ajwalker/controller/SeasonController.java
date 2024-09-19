package com.ajwalker.controller;

import com.ajwalker.entity.Season;
import com.ajwalker.service.SeasonService;

public class SeasonController extends ControllerManager<Season,Long>{
	private static SeasonController instance;
	public SeasonController() {
		super(SeasonService.getInstance());
	}
	public static SeasonController getInstance() {
		if (instance == null) {
			instance = new SeasonController();
		}
		return instance;
	}
}