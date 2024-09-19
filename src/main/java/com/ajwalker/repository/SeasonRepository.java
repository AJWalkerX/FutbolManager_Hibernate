package com.ajwalker.repository;

import com.ajwalker.entity.Season;

public class SeasonRepository extends RepositoryManager<Season,Long>{
	private static SeasonRepository instance;
	private SeasonRepository() {
		super(Season.class);
	}
	public static SeasonRepository getInstance() {
		if (instance == null) {
			instance = new SeasonRepository();
		}
		return instance;
	}
}