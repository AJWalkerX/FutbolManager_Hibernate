package com.ajwalker.controller;

import com.ajwalker.entity.Stadium;
import com.ajwalker.service.StadiumService;

public class StadiumController extends ControllerManager<Stadium,Long>{
	private static StadiumController instance;
	private StadiumController() {
		super(StadiumService.getInstance());
	}
	public static StadiumController getInstance() {
		if (instance == null) {
			instance = new StadiumController();
		}
		return instance;
	}
}