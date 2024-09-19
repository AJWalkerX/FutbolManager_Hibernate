package com.ajwalker.repository;

import com.ajwalker.entity.Player;

public class PlayerRepository extends RepositoryManager<Player,Long>{
	public PlayerRepository() {
		super(Player.class);
	}
}