package com.ajwalker.utility.engine;

import com.ajwalker.entity.BetOdds;
import com.ajwalker.entity.Match;
import com.ajwalker.entity.Player;
import com.ajwalker.entity.Team;
import com.ajwalker.repository.MatchRepository;
import com.ajwalker.repository.TeamRepository;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class BetOddsEngine {
    private static  Random random = new Random();
    private static TeamRepository teamRepository = TeamRepository.getInstance();



    public static BetOdds getMatchBetOdds(Match match) {
        Team homeTeam = teamRepository.findById(match.getHomeTeamId()).get();
        Team awayTeam = teamRepository.findById(match.getAwayTeamId()).get();
        double homeTeamPower = homeTeam.getPlayers().stream().collect(Collectors.averagingDouble(Player::getSkillLevel));
        double awayTeamPower = awayTeam.getPlayers().stream().collect(Collectors.averagingDouble(Player::getSkillLevel));

        BetOdds betOdds = BetOdds.builder().match(match).build();
        BigDecimal homeTeamWins = BigDecimal.valueOf(calculateHomeTeamWinOdd(homeTeamPower, awayTeamPower));
        BigDecimal awayTeamWins = BigDecimal.valueOf(calculateAwayTeamWinOdd(awayTeamPower, homeTeamPower));
        double drawDouble = ((homeTeamWins.doubleValue()+awayTeamWins.doubleValue())/2)+ random.nextDouble(0.12);//random standart sapma için
        BigDecimal draw = BigDecimal.valueOf(drawDouble);
        BigDecimal totalGoals3OrMore = BigDecimal.valueOf(calculate3GoalsOrAboveOdd());
        BigDecimal totalGoals2OrLess = BigDecimal.valueOf(calculate2GoalsOrBeloveOdd());

        betOdds.setHomeTeamWins(homeTeamWins);
        betOdds.setAwayTeamWins(awayTeamWins);
        betOdds.setDraw(draw);
        betOdds.setTotalGoalsEqual3OrMore(totalGoals3OrMore);
        betOdds.setTotalGoalsEqual2OrLess(totalGoals2OrLess);
        return betOdds;

    }

    private static Double calculateHomeTeamWinOdd(Double homeTeamPower, Double awayTeamPower) {
        double homeTeamWinProbability = 50+(homeTeamPower-awayTeamPower)*0.5;
        return ((1/homeTeamWinProbability)*100);


    }
    private static  Double calculateAwayTeamWinOdd(Double homeTeamPower, Double awayTeamPower){
        double awayTeamWinProbability = 50+(awayTeamPower-homeTeamPower)*0.5;
        return ((1/awayTeamWinProbability)*100);
    }

    private static  Double calculate3GoalsOrAboveOdd(){
        return random.nextDouble(1.30,1.61);
    }
    private static  Double calculate2GoalsOrBeloveOdd(){
        return random.nextDouble(1.65,2.10);
    }




}
