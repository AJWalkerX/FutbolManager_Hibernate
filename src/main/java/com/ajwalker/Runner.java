package com.ajwalker;

import com.ajwalker.entity.League;
import com.ajwalker.entity.Player;
import com.ajwalker.entity.Season;
import com.ajwalker.repository.LeagueRepository;
import com.ajwalker.repository.RepositoryManager;
import com.ajwalker.repository.SeasonRepository;
import com.ajwalker.service.LeagueService;
import com.ajwalker.utility.HibernateConnection;
import com.ajwalker.utility.enums.ERegion;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Runner {
    public static void main(String[] args) {
        HibernateConnection.beginConnection();

        LeagueService leagueService = new LeagueService();
        
        
        
//        Season season = Season.builder().BEGINNING_OF_SEASON(LocalDate.of(2024,8,10)).build();
//        // seasonRepository.save(season);
//
//        League league = League.builder().region(ERegion.ENGLAND).season(season).build();
//        leagueService.save(league);
//
//        //leagueRepository.softDeleteByID(1L);
//
        HibernateConnection.em.getTransaction().commit();
        
        HibernateConnection.connectionClose();
    }
}