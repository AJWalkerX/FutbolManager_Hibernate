package com.ajwalker.service;

import com.ajwalker.entity.Match;
import com.ajwalker.entity.Season;
import com.ajwalker.repository.ICRUD;
import com.ajwalker.repository.SeasonRepository;

public class SeasonService extends ServiceManager<Season,Long>{
	private static SeasonService instance;
	private SeasonRepository seasonRepository = SeasonRepository.getInstance();
	private SeasonService(ICRUD<Season, Long> repository) {
		super(SeasonRepository.getInstance());
	}
	public static SeasonService getInstance() {
		if (instance == null) {
			instance = new SeasonService(SeasonRepository.getInstance());
		}
		return instance;
	}
	
	public void updateCurrentDate(Season season, Match match) {
		season.setCurrentDate(match.getMatchDate());
		seasonRepository.update(season);
	}
}