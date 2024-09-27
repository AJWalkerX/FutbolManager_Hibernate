package com.ajwalker.gui.match_gui;

import com.ajwalker.entity.League;
import com.ajwalker.entity.Manager;
import com.ajwalker.gui.league_gui.DetailedLeagueMenu;
import com.ajwalker.gui.league_gui.LeagueMenu;
import com.ajwalker.gui.manager_gui.ManagerLoginRegister;
import com.ajwalker.service.MatchService;

import java.util.Optional;

import static com.ajwalker.utility.ConsoleTextUtils.*;

public class MatchMenu {
    private Optional<Manager> manager;
    private League league;
    private static MatchMenu instance;

    private MatchMenu() {}
    public static MatchMenu getInstance() {
        if (instance == null) {
            instance = new MatchMenu();
        }
        return instance;
    }




    public void matchMenu(Optional<Manager> manager){
        this.manager = manager;
        boolean opt = true;
        this.league = LeagueMenu.getInstance().selectLeague();
        if (this.league == null){
            System.out.println("No such league found!");
        }else {
            do{
                if (!this.manager.isEmpty()) opt = matchInfoMenu();
                else this.manager = ManagerLoginRegister.getInstance().loginRegisterMenu();
            } while(opt);
        }
    }

    private boolean matchInfoMenu() {
        printTitle("Match Menu");
        printMenuOptions("Play a Match","Play Several Match","Play All Matches",
                "Show Played Matches","Show Standings",
                "Return To Main Menu");

        return matchInfoMenuOptions(getIntUserInput("Select: "));
    }

    private boolean matchInfoMenuOptions(int userInput) {
        switch(userInput){
            case 1:
                MatchService.getInstance().playMatch();
                break;
            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                System.out.println("Returning to Main Menu");
                return false;
        }
        return true;
    }


}
