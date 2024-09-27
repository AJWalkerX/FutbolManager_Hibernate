package com.ajwalker.repository;

import com.ajwalker.entity.MatchStats;

import java.util.List;

public class MatchStatsRepository extends RepositoryManager<MatchStats, Long> {
    private static MatchStatsRepository instance;
    private MatchStatsRepository() {
        super(MatchStats.class);
    }
    public static MatchStatsRepository getInstance() {
        if (instance == null) {
            instance = new MatchStatsRepository();
        }
        return instance;
    }
}
