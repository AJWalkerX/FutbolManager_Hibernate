package com.ajwalker.model;

import com.ajwalker.entity.Bet;
import com.ajwalker.entity.BetOdds;
import com.ajwalker.entity.Gambler;
import com.ajwalker.entity.Team;
import com.ajwalker.service.BetService;
import com.ajwalker.service.TeamService;
import com.ajwalker.utility.enums.EOddSelection;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BetModel {

    private BetService betService = BetService.getInstance();

    private Bet bet;
    private Map<BetOdds, EOddSelection> selectionMap;
    private TeamService teamService = TeamService.getInstance();


    public BetModel(Bet bet, Map<BetOdds,EOddSelection> selectionMap) {
        this.bet = bet;
        this.selectionMap = selectionMap;
    }


    public void displayMyBet(){
        AtomicInteger counter = new AtomicInteger(1);
        System.out.println("------------------------------------------------------------");
        System.out.println("---------------------------MY BET---------------------------");
        selectionMap.forEach((k,v)->{
            Team homeTeam = teamService.findById(k.getMatch().getHomeTeamId()).get();
            Team awayTeam = teamService.findById(k.getMatch().getAwayTeamId()).get();
            String output = String.format("%d: %-15s - %-20s %-14s %.2f "
                    ,counter.getAndIncrement()
                    ,homeTeam.getTeamName()
                    ,awayTeam.getTeamName()
                    ,k.getMatch().getMatchDate().toString()
                    ,betService.getSelectedBetOdd(k,v));
            System.out.println(output);


        });
            System.out.println("Total odds     : "+bet.getTotalBetOdd());
        if(bet.getBetAmount()!=null){
            System.out.println("Amount         : "+bet.getBetAmount()+" ₺");
            System.out.println("Total Winnings : "+bet.getTotalBetOdd().multiply(bet.getBetAmount())+" ₺");
        }
        System.out.println("------------------------------------------------------------");
    }






}
