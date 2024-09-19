package com.ajwalker.service;

import com.ajwalker.entity.League;
import com.ajwalker.repository.LeagueRepository;

public class LeagueService extends ServiceManager<League,Long> {
	
	private static LeagueService instance;
	private LeagueService() {
		super(LeagueRepository.getInstance());
		
	}
	
//	public LeagueService(LeagueRepository leagueRepository) {
//		super(leagueRepository);
//		this.leagueRepository = leagueRepository;
//	}
	public static LeagueService getInstance() {
		if (instance == null) {
			instance = new LeagueService();
		}
		return instance;
	}
}