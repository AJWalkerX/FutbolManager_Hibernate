package com.ajwalker.service;

import com.ajwalker.entity.Match;
import com.ajwalker.repository.ICRUD;
import com.ajwalker.repository.ManagerRepository;
import com.ajwalker.repository.MatchRepository;

public class MatchService extends ServiceManager<Match,Long> {
	public MatchService() {
		super(MatchRepository.getInstance());
	}
}