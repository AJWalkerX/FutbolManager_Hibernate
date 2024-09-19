package com.ajwalker.repository;

import com.ajwalker.entity.Fixture;

public class FixtureRepository extends RepositoryManager<Fixture,Long>{
	private static FixtureRepository instance;
	
	public FixtureRepository() {
		super(Fixture.class);
	}
	public static FixtureRepository getInstance() {
		if (instance == null) {
			instance = new FixtureRepository();
			
		}
		return instance;
	}
}