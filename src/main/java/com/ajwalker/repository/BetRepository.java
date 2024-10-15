package com.ajwalker.repository;

import com.ajwalker.entity.Bet;
import com.ajwalker.entity.Gambler;

import java.util.ArrayList;
import java.util.List;

public class BetRepository extends RepositoryManager<Bet,Long>{

    private static BetRepository instance;

    private BetRepository() {
        super(Bet.class);
    }

    public static BetRepository getInstance() {
        if (instance == null) {
            instance = new BetRepository();
        }
        return instance;
    }

    List<Bet> getBetsOfGambler(Gambler gambler){
        return findByFieldNameAndValue("gambler", gambler);
    }

}
