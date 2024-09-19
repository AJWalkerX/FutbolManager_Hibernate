package com.ajwalker.repository;

import com.ajwalker.entity.Fixture;

public class FixtureRepository extends RepositoryManager<Fixture,Long>{
	public FixtureRepository() {
		super(Fixture.class);
	}
}