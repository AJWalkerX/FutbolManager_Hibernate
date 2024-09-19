package com.ajwalker.repository;

import com.ajwalker.entity.Team;

public class TeamRepository extends RepositoryManager<Team,Long>{
	public TeamRepository() {
		super(Team.class);
	}
}