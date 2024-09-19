package com.ajwalker.service;

import com.ajwalker.entity.Season;
import com.ajwalker.repository.ICRUD;

public class SeasonService extends ServiceManager<Season,Long>{//
	public SeasonService(ICRUD<Season, Long> repository) {
		super(repository);
	}
}