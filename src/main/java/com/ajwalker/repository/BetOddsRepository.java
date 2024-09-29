package com.ajwalker.repository;

import com.ajwalker.entity.BetOdds;

public class BetOddsRepository extends RepositoryManager<BetOdds,Long>{
    private static BetOddsRepository instance;

    private BetOddsRepository() {
        super(BetOdds.class);
    }
    public static BetOddsRepository getInstance() {
        if (instance == null) {
            return new BetOddsRepository();
        }
        return instance;
    }
}
