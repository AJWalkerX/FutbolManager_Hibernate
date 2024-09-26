package com.ajwalker.service;

import com.ajwalker.entity.Fixture;
import com.ajwalker.entity.Match;
import com.ajwalker.repository.MatchRepository;
import com.ajwalker.utility.ConsoleTextUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MatchService extends ServiceManager<Match, Long> {
	MatchRepository matchRepository = MatchRepository.getInstance();
	
	private static MatchService instance;
	
	private MatchService() {
		super(MatchRepository.getInstance());
	}
	
	public static MatchService getInstance() {
		if (instance == null) {
			instance = new MatchService();
		}
		return instance;
	}
	
	public List<Match> findMatchesByFixture(Fixture fixture) {
		List<Match> matches = matchRepository.findByFieldNameAndValue("fixture", fixture);
		if (!matches.isEmpty()) {
			return matches.stream().sorted(Comparator.comparing(Match::getMatchDate)).toList();
		}
		ConsoleTextUtils.printErrorMessage("No matches found for fixture: " + fixture);
		return new ArrayList<>();
	}
	
}