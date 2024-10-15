package com.ajwalker.model;

import com.ajwalker.entity.Bet;
import com.ajwalker.entity.BetOdds;
import com.ajwalker.entity.Gambler;
import com.ajwalker.service.BetSelectionService;
import com.ajwalker.utility.enums.EOddSelection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GamblerModel {
    private BetSelectionService betSelectionService = BetSelectionService.getInstance();

    private Gambler gambler;

    public GamblerModel(Gambler gambler) {
        this.gambler = gambler;
    }

    public void displayMyPreviousBets(){
        List<Bet> betList = gambler.getBetList();
        if(betList.isEmpty()){
            System.out.println("No bets found");
            return;
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println(gambler.getName()+"'s previous bets:");
        System.out.println("-----------------------------------------------------------");
        for(Bet bet : betList){
            Map<BetOdds, EOddSelection> betOddsEOddSelectionMap =  betSelectionService.getBetSelectionMap(bet);
            new BetModel(bet,betOddsEOddSelectionMap).displayMyBet();
        }
        System.out.println("-----------------------------------------------------------");
    }
}
