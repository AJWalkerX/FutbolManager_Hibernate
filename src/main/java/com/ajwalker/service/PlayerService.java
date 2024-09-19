package com.ajwalker.service;

import com.ajwalker.entity.Player;
import com.ajwalker.repository.ICRUD;

public class PlayerService extends ServiceManager<Player,Long>{
	public PlayerService(ICRUD<Player, Long> repository) {
		super(repository);
		//
	}
}