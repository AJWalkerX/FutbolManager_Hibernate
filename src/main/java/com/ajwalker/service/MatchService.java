package com.ajwalker.service;

import com.ajwalker.entity.*;
import com.ajwalker.repository.*;
import com.ajwalker.utility.ConsoleTextUtils;
import com.ajwalker.utility.engine.MatchEngine;
import com.ajwalker.utility.enums.EState;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MatchService extends ServiceManager<Match, Long> {
    MatchRepository matchRepository = MatchRepository.getInstance();
    StatsRepository statsRepository = StatsRepository.getInstance();

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

    public void playMatch() {
        List<Match> matches = matchRepository.findByFieldNameAndValue("isPlayed", false).
                stream().filter(match -> {
                    Team homeTeam = TeamRepository.getInstance().findById(match.getHomeTeamId()).get();
                    Team awayTeam = TeamRepository.getInstance().findById(match.getAwayTeamId()).get();
                    return !(homeTeam.getTeamName().equals("BAY") || awayTeam.getTeamName().equalsIgnoreCase("BAY"));
                }).sorted(Comparator.comparing(Match::getMatchDate)).toList();

        Match match = matches.getFirst();
        MatchEngine.simulateMatch(match);

        Stats homeTeam = statsRepository.findById(match.getHomeTeamId()).get();
        Stats awayTeam = statsRepository.findById(match.getAwayTeamId()).get();


        updatePoints(match, homeTeam, awayTeam);
        match.setPlayed(true);
        matchRepository.update(match);
    }

    private void updatePoints(Match match, Stats homeTeam, Stats awayTeam) {
        homeTeam.setGamesPlayed(homeTeam.getGamesPlayed() + 1);
        awayTeam.setGamesPlayed(awayTeam.getGamesPlayed() + 1);

        homeTeam.setGoalsFor(homeTeam.getGoalsFor() + match.getHomeTeamScore());
        awayTeam.setGoalsFor(awayTeam.getGoalsFor() + match.getAwayTeamScore());
        homeTeam.setGoalsAgainst(homeTeam.getGoalsAgainst() + match.getAwayTeamScore());
        awayTeam.setGoalsAgainst(awayTeam.getGoalsAgainst() + match.getHomeTeamScore());
        homeTeam.setGoalDifference(homeTeam.getGoalsFor() - homeTeam.getGoalsAgainst());
        awayTeam.setGoalDifference(awayTeam.getGoalsFor() - awayTeam.getGoalsAgainst());

        if (match.getHomeTeamScore() > match.getAwayTeamScore()) {
            homeTeam.setTotalWins(homeTeam.getTotalWins() + 1);
            awayTeam.setTotalLoses(awayTeam.getTotalLoses() + 1);
        } else if (match.getAwayTeamScore() > match.getHomeTeamScore()) {
            awayTeam.setTotalWins(awayTeam.getTotalWins() + 1);
            homeTeam.setTotalLoses(homeTeam.getTotalLoses() + 1);
        } else {
            homeTeam.setTotalDraws(homeTeam.getTotalDraws() + 1);
            awayTeam.setTotalDraws(awayTeam.getTotalDraws() + 1);
        }
        homeTeam.setPoints((homeTeam.getTotalWins() * 3) + (homeTeam.getTotalDraws()));
        awayTeam.setPoints((awayTeam.getTotalWins() * 3) + awayTeam.getTotalDraws());
        statsRepository.updateAll(List.of(homeTeam, awayTeam));
    }

    public List<Match> displayWeeklyBets(){
        return new ArrayList<>();
    }
}


