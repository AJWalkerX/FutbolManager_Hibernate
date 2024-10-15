package com.ajwalker.repository;

import com.ajwalker.entity.Bet;
import com.ajwalker.entity.BetOdds;
import com.ajwalker.entity.BetSelectionMap;
import com.ajwalker.utility.HibernateConnection;
import com.ajwalker.utility.enums.EOddSelection;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BetSelectionMapRepository extends RepositoryManager<BetSelectionMap, Long> {

    private static BetSelectionMapRepository instance;

    private BetSelectionMapRepository() {
        super(BetSelectionMap.class);
    }

    public static BetSelectionMapRepository getInstance() {
        if (instance == null) {
            instance = new BetSelectionMapRepository();
        }
        return instance;
    }

    public List<BetSelectionMap> getBetsSelectionMapList(Bet bet) {
        Map<BetOdds, EOddSelection> map = new HashMap<BetOdds, EOddSelection>();
        CriteriaBuilder cb = HibernateConnection.em.getCriteriaBuilder();
        CriteriaQuery<BetSelectionMap> cq = cb.createQuery(BetSelectionMap.class);
        Root<BetSelectionMap> root = cq.from(BetSelectionMap.class);
        cq.select(root).where(cb.equal(root.get("bet_id"), bet.getId()));
        return HibernateConnection.em.createQuery(cq).getResultList();
    }

}
