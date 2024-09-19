package com.ajwalker.service;

import com.ajwalker.entity.Team;
import com.ajwalker.repository.TeamRepository;

public class TeamService extends ServiceManager<Team,Long>{

	private static TeamService instance;
	private TeamService() {
		super(TeamRepository.getInstance());
	
	}
	public static TeamService getInstance() {
		if (instance == null) {
			instance = new TeamService();
			
		}
		return instance;
	}
}