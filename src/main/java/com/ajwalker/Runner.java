package com.ajwalker;

import com.ajwalker.controller.LeagueController;
import com.ajwalker.controller.SeasonController;
import com.ajwalker.entity.League;
import com.ajwalker.entity.Season;
import com.ajwalker.utility.Data.DemoData;
import com.ajwalker.utility.HibernateConnection;
import com.ajwalker.utility.enums.ERegion;
import java.time.LocalDate;

public class Runner {
    public static void main(String[] args) {
        HibernateConnection.beginConnection();


        DemoData.GenerateDemonData();



        HibernateConnection.em.getTransaction().commit();
        
        HibernateConnection.connectionClose();
    }
}