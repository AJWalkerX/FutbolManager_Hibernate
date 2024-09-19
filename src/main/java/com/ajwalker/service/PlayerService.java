package com.ajwalker.service;

import com.ajwalker.entity.Player;
import com.ajwalker.repository.ICRUD;
import com.ajwalker.repository.PlayerRepository;

public class PlayerService extends ServiceManager<Player,Long>{
	
	public PlayerService() {
		super(PlayerRepository.getInstance());
		
	}
}