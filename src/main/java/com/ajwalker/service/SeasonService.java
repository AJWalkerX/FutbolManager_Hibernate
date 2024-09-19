package com.ajwalker.service;

import com.ajwalker.entity.Season;
import com.ajwalker.repository.ICRUD;
import com.ajwalker.repository.SeasonRepository;

public class SeasonService extends ServiceManager<Season,Long>{
	private static SeasonService instance;
	private SeasonService(ICRUD<Season, Long> repository) {
		super(SeasonRepository.getInstance());
	}
	public static SeasonService getInstance() {
		if (instance == null) {
			instance = new SeasonService(SeasonRepository.getInstance());
		}
		return instance;
	}
}