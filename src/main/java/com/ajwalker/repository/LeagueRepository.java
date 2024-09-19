package com.ajwalker.repository;

import com.ajwalker.entity.League;

public class LeagueRepository extends RepositoryManager<League,Long>{
	
	public LeagueRepository() {
		super(League.class);
	}
}