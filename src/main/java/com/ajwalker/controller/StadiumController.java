package com.ajwalker.controller;

import com.ajwalker.entity.Stadium;
import com.ajwalker.service.StadiumService;

public class StadiumController {
	private static StadiumController instance;
	private StadiumController() {
	
	}
	public static StadiumController getInstance() {
		if (instance == null) {
			instance = new StadiumController();
		}
		return instance;
	}
}