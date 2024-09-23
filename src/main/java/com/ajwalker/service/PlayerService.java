package com.ajwalker.service;

import com.ajwalker.entity.Player;
import com.ajwalker.entity.Team;
import com.ajwalker.repository.PlayerRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

import static com.ajwalker.utility.HibernateConnection.em;

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
	
	public List<Player> findByTeam(Team team) {
		return PlayerRepository.getInstance().findByTeam(team);
		
	}
}