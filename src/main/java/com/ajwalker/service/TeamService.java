package com.ajwalker.service;

import com.ajwalker.entity.Team;
import com.ajwalker.repository.ICRUD;
import com.ajwalker.repository.TeamRepository;

public class TeamService extends ServiceManager<Team,Long>{
	
	public TeamService() {
		super(TeamRepository.getInstance());
	
	}
}