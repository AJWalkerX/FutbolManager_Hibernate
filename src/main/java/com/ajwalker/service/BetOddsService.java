package com.ajwalker.service;

import com.ajwalker.entity.BetOdds;
import com.ajwalker.repository.BetOddsRepository;
import com.ajwalker.repository.ICRUD;

public class BetOddsService extends ServiceManager<BetOdds,Long> {
    private static BetOddsService instance;

    private BetOddsService() {
        super(BetOddsRepository.getInstance());
    }
    public static BetOddsService getInstance() {
        if (instance == null) {
            instance = new BetOddsService();
        }
        return instance;
    }

}
