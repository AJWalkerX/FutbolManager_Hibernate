package com.ajwalker.repository;

import com.ajwalker.entity.Match;

public class MatchRepository extends RepositoryManager<Match,Long>{
	public MatchRepository() {
		super(Match.class);
	}
}