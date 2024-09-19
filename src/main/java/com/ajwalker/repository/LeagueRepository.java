package com.ajwalker.repository;

import com.ajwalker.entity.League;

public class LeagueRepository extends RepositoryManager<League,Long>{
	private static LeagueRepository instance;
	
	private LeagueRepository() {
		super(League.class);
	}
	public static LeagueRepository getInstance() {
		if (instance == null) {
			instance = new LeagueRepository();
		}
		return instance;
	}
}