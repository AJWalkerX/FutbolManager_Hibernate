package com.ajwalker.controller;

import com.ajwalker.entity.Fixture;
import com.ajwalker.service.FixtureService;

public class FixtureController extends ControllerManager<Fixture,Long>{
	private static FixtureController instance;
	
	private FixtureController() {
		super(FixtureService.getInstance());
	}
	public static FixtureController getInstance() {
		if (instance == null) {
			instance =new FixtureController();
		}
		return instance;
	}
}