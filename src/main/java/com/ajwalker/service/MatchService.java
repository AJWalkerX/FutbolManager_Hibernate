package com.ajwalker.service;

import com.ajwalker.entity.Match;
import com.ajwalker.repository.MatchRepository;

public class MatchService extends ServiceManager<Match,Long> {
	
	private static  MatchService instance;
	private MatchService() {
		super(MatchRepository.getInstance());
	}
	public static MatchService getInstance() {
		if (instance == null) {
			instance = new MatchService();
		}
		return instance;
	}
}