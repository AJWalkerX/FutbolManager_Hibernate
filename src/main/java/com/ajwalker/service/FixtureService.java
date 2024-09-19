package com.ajwalker.service;

import com.ajwalker.entity.Fixture;
import com.ajwalker.repository.ICRUD;

public class FixtureService extends ServiceManager<Fixture,Long>{
	
	public FixtureService(ICRUD<Fixture, Long> repository) {
		super(repository);
	}
}