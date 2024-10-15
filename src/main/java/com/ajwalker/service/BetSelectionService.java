package com.ajwalker.service;

import com.ajwalker.entity.Bet;
import com.ajwalker.entity.BetOdds;
import com.ajwalker.entity.BetSelectionMap;
import com.ajwalker.repository.BetSelectionMapRepository;
import com.ajwalker.repository.ICRUD;
import com.ajwalker.utility.enums.EOddSelection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BetSelectionService extends ServiceManager<BetSelectionMap,Long> {

    private static BetSelectionService instance;
    private BetSelectionMapRepository betSelectionMapRepository = BetSelectionMapRepository.getInstance();
    private BetOddsService betOddsService = BetOddsService.getInstance();

    private BetSelectionService() {
        super(BetSelectionMapRepository.getInstance());
    }
    public static BetSelectionService getInstance() {
        if (instance == null) {
            instance = new BetSelectionService();
        }
        return instance;
    }

    public Map<BetOdds, EOddSelection> getBetSelectionMap(Bet bet) {
        Map<BetOdds,EOddSelection> map = new HashMap<>();
        List<BetSelectionMap> betSelectionMapList = betSelectionMapRepository.getBetsSelectionMapList(bet);
        for(BetSelectionMap betSelectionMap : betSelectionMapList) {
            BetOdds betOdd = betOddsService.findById(betSelectionMap.getBetOdds_id()).get();
            EOddSelection oddSelection= betSelectionMap.getOddSelection();
            map.put(betOdd, oddSelection);
        }
        return map;
    }
}
