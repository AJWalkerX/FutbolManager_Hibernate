package com.ajwalker.controller;

import com.ajwalker.entity.Fixture;
import com.ajwalker.service.FixtureService;

public class FixtureController {
	private static FixtureController instance;
	
	private FixtureController() {
	
	}
	public static FixtureController getInstance() {
		if (instance == null) {
			instance =new FixtureController();
		}
		return instance;
	}
}