package com.ajwalker.service;

import com.ajwalker.entity.Stadium;
import com.ajwalker.repository.StadiumRepository;

public class StadiumService extends ServiceManager<Stadium,Long>{
	private static StadiumService instance;
	private StadiumService() {
		super(StadiumRepository.getInstance());
	}
	public static StadiumService getInstance() {
		if (instance == null) {
			instance = new StadiumService();
		}
		return instance;
	}
}