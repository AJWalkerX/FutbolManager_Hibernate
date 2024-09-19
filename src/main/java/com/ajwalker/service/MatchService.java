package com.ajwalker.service;

import com.ajwalker.entity.Match;
import com.ajwalker.repository.ICRUD;

public class MatchService extends ServiceManager<Match,Long> {
	public MatchService(ICRUD<Match, Long> repository) {
		super(repository);
	}//
}