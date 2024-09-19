package com.ajwalker.service;

import com.ajwalker.entity.Season;
import com.ajwalker.repository.ICRUD;
import com.ajwalker.repository.SeasonRepository;

public class SeasonService extends ServiceManager<Season,Long>{
	public SeasonService(ICRUD<Season, Long> repository) {
		super(SeasonRepository.getInstance());
	}
}