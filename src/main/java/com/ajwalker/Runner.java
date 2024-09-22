package com.ajwalker;

import com.ajwalker.controller.LeagueController;
import com.ajwalker.controller.SeasonController;
import com.ajwalker.entity.Fixture;
import com.ajwalker.entity.League;
import com.ajwalker.entity.Season;
import com.ajwalker.utility.Data.DemoData;
import com.ajwalker.utility.Data.FixtureGenerator;
import com.ajwalker.utility.HibernateConnection;
import com.ajwalker.utility.enums.ERegion;
import java.time.LocalDate;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        HibernateConnection.beginConnection();


        DemoData.GenerateDemonData();
        welcomeMassege();
        HibernateConnection.em.getTransaction().commit();
        
        HibernateConnection.connectionClose();
    }

    private static void welcomeMassege(){
        String title = """
                ███████╗ ██████╗  ██████╗ ████████╗██████╗  █████╗ ██╗     ██╗    \s
                ██╔════╝██╔═══██╗██╔═══██╗╚══██╔══╝██╔══██╗██╔══██╗██║     ██║    \s
                █████╗  ██║   ██║██║   ██║   ██║   ██████╔╝███████║██║     ██║    \s
                ██╔══╝  ██║   ██║██║   ██║   ██║   ██╔══██╗██╔══██║██║     ██║    \s
                ██║     ╚██████╔╝╚██████╔╝   ██║   ██████╔╝██║  ██║███████╗███████╗
                ╚═╝      ╚═════╝  ╚═════╝    ╚═╝   ╚═════╝ ╚═╝  ╚═╝╚══════╝╚══════╝
                                                                                  \s
                ███╗   ███╗ █████╗ ███╗   ██╗ █████╗  ██████╗ ███████╗██████╗     \s
                ████╗ ████║██╔══██╗████╗  ██║██╔══██╗██╔════╝ ██╔════╝██╔══██╗    \s
                ██╔████╔██║███████║██╔██╗ ██║███████║██║  ███╗█████╗  ██████╔╝    \s
                ██║╚██╔╝██║██╔══██║██║╚██╗██║██╔══██║██║   ██║██╔══╝  ██╔══██╗    \s
                ██║ ╚═╝ ██║██║  ██║██║ ╚████║██║  ██║╚██████╔╝███████╗██║  ██║    \s
                ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝    \s
                                                                                  \s
                """;
        System.out.println(title);
        System.out.println("Press any key to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}