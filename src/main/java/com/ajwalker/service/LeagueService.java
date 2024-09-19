package com.ajwalker.service;

import com.ajwalker.entity.League;
import com.ajwalker.repository.ICRUD;
import com.ajwalker.repository.LeagueRepository;

public class LeagueService extends ServiceManager<League,Long> {
	public LeagueService() {
		super(LeagueRepository.getInstance());
		
	}
	
//	public LeagueService(LeagueRepository leagueRepository) {
//		super(leagueRepository);
//		this.leagueRepository = leagueRepository;
//	}
}