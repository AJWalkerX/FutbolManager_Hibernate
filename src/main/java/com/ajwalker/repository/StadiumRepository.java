package com.ajwalker.repository;

import com.ajwalker.entity.Stadium;

public class StadiumRepository extends RepositoryManager<Stadium,Long>{
	private static StadiumRepository instance;
	private StadiumRepository() {
		super(Stadium.class);
	}
	public static StadiumRepository getInstance() {
		if (instance == null) {
			instance = new StadiumRepository();
		}
		return instance;
	}
}