package com.ajwalker.service;

import com.ajwalker.entity.Bet;
import com.ajwalker.entity.Gambler;
import com.ajwalker.repository.BetRepository;
import com.ajwalker.repository.ICRUD;

public class BetService extends ServiceManager<Bet,Long>{
    private static BetService instance;

    private BetService() {
        super(BetRepository.getInstance());
    }

    public static BetService getInstance() {
        if (instance == null) {
            instance = new BetService();
        }
        return instance;
    }






    public boolean checkGamblerAccountBalance(Gambler gambler,Double priceToBet){
        if(gambler.getAccountBalance()>priceToBet){
            return true;
        }
        System.out.println("Your accountBalance is not enough to place this amount for bet.");
        return false;
    }


}
