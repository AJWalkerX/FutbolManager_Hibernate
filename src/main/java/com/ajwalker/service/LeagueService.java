package com.ajwalker.service;

import com.ajwalker.entity.League;
import com.ajwalker.repository.ICRUD;
import com.ajwalker.repository.LeagueRepository;

public class LeagueService extends ServiceManager<League,Long> {
	private final LeagueRepository leagueRepository;//
	
	public LeagueService() {
		this(new LeagueRepository());
	}
	
	public LeagueService(LeagueRepository leagueRepository) {
		super(leagueRepository);
		this.leagueRepository = leagueRepository;
	}
}