package com.ajwalker.repository;

import com.ajwalker.entity.Player;

public class PlayerRepository extends RepositoryManager<Player,Long>{
	private static PlayerRepository instance;
	private PlayerRepository() {
		super(Player.class);
	}
	public static  PlayerRepository getInstance() {
		if (instance == null) {
			instance = new PlayerRepository();
		}
		return instance;
	}
}