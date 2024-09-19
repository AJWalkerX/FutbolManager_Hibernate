package com.ajwalker.service;

import com.ajwalker.entity.Team;
import com.ajwalker.repository.ICRUD;
import com.ajwalker.repository.TeamRepository;

public class TeamService extends ServiceManager<Team,Long>{//
	private final TeamRepository teamRepository;
	
	public TeamService() {
		this(new TeamRepository());
	}
	
	public TeamService(TeamRepository teamRepository) {
		super(teamRepository);
		this.teamRepository = teamRepository;
	}
}