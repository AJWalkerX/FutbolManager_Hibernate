package com.ajwalker.service;

import com.ajwalker.entity.Fixture;
import com.ajwalker.repository.FixtureRepository;


public class FixtureService extends ServiceManager<Fixture,Long>{
	
	private static FixtureService instance;
	
	private FixtureService() {
		super(FixtureRepository.getInstance());
	}
	public static FixtureService getInstance() {
		if (instance == null) {
			instance = new FixtureService();
		}
		return instance;
	}
}