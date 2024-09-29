package com.ajwalker.repository;

import com.ajwalker.entity.BetOdds;
import com.ajwalker.utility.HibernateConnection;
import com.ajwalker.utility.enums.EBetOddsState;
import com.ajwalker.utility.enums.EState;

import java.time.LocalDate;

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

    @Override //EBetOddsState default ON_WAIT atamak için override edildi.
    public BetOdds save(BetOdds betOdds) {
        betOdds.setEBetOddsState(EBetOddsState.ON_WAIT);
        betOdds.setState(EState.ACTIVE);
        betOdds.setCreateAt(LocalDate.now());
        betOdds.setUpdateAt(LocalDate.now());
        HibernateConnection.em.persist(betOdds);
        return betOdds;
    }
}
