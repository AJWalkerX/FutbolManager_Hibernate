package com.ajwalker.controller;

import com.ajwalker.entity.Player;
import com.ajwalker.service.PlayerService;

public class PlayerController {
	private static PlayerController instance;
	private PlayerController() {

	}
	public static PlayerController getInstance() {
		if (instance == null) {
			instance = new PlayerController();
		}
		return instance;
	}
}