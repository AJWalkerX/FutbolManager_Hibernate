package com.ajwalker.controller;

import com.ajwalker.entity.Player;
import com.ajwalker.service.PlayerService;

public class PlayerController extends ControllerManager<Player,Long>{
	private static PlayerController instance;
	private PlayerController() {
		super(PlayerService.getInstance());
	}
	public static PlayerController getInstance() {
		if (instance == null) {
			instance = new PlayerController();
		}
		return instance;
	}
}