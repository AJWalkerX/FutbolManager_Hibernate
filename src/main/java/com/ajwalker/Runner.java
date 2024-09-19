package com.ajwalker;

import com.ajwalker.controller.LeagueController;
import com.ajwalker.controller.SeasonController;
import com.ajwalker.entity.League;
import com.ajwalker.entity.Season;
import com.ajwalker.utility.HibernateConnection;
import com.ajwalker.utility.enums.ERegion;
import java.time.LocalDate;

public class Runner {
    public static void main(String[] args) {
        HibernateConnection.beginConnection();
        
        
        Season season = Season.builder().BEGINNING_OF_SEASON(LocalDate.of(2024,8,10)).build();
        SeasonController.getInstance().save(season);
        

        League league = League.builder().region(ERegion.ENGLAND).season(season).build();
        LeagueController.getInstance().save(league);

        //leagueRepository.softDeleteByID(1L);
//
        HibernateConnection.em.getTransaction().commit();
        
        HibernateConnection.connectionClose();
    }
}