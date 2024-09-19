package com.ajwalker.repository;

import com.ajwalker.entity.Season;

public class SeasonRepository extends RepositoryManager<Season,Long>{
	public SeasonRepository() {
		super(Season.class);
	}
}