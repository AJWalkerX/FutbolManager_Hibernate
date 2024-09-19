package com.ajwalker;

import com.ajwalker.entity.League;
import com.ajwalker.entity.Player;
import com.ajwalker.entity.Season;
import com.ajwalker.repository.LeagueRepository;
import com.ajwalker.repository.RepositoryManager;
import com.ajwalker.repository.SeasonRepository;
import com.ajwalker.utility.enums.ERegion;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Runner {
    public static void main(String[] args) {
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Futbol_ManagerV2");
        
        LeagueRepository leagueRepository = new LeagueRepository();
        SeasonRepository seasonRepository = new SeasonRepository();
        
        
        
        Season season = Season.builder().BEGINNING_OF_SEASON(LocalDate.of(2024,8,10)).build();
         seasonRepository.save(season);
        
        League league = League.builder().region(ERegion.ENGLAND).season(season).build();
        leagueRepository.save(league);

        leagueRepository.softDeleteByID(1L);
    }
}