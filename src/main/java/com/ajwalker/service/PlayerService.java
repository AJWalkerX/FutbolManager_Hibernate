package com.ajwalker.service;

import com.ajwalker.entity.Player;
import com.ajwalker.repository.PlayerRepository;

public class PlayerService extends ServiceManager<Player,Long>{
	private static PlayerService instance;
	private PlayerService() {
		super(PlayerRepository.getInstance());
		
	}
	public static PlayerService getInstance() {
		if (instance == null) {
			instance = new PlayerService();
		}
		return instance;
	}
}