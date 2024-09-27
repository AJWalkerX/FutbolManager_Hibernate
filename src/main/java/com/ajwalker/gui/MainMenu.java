package com.ajwalker.gui;

import com.ajwalker.entity.Manager;
import com.ajwalker.gui.league_gui.LeagueMenu;
import com.ajwalker.gui.manager_gui.ManagerDashboard;
import com.ajwalker.gui.manager_gui.ManagerLoginRegister;

import java.util.Optional;
import static com.ajwalker.utility.ConsoleTextUtils.*;


public class MainMenu {
    private Optional<Manager> manager = Optional.empty();
    private static MainMenu instance;

    private MainMenu() {}
    public static MainMenu getInstance() {
        if (instance == null) {
            instance = new MainMenu();
        }
        return instance;
    }




    public void mainMenu(){
        boolean opt;
        do{
            if (manager.isEmpty()) opt = anonymousMainMenu();
            //-->             <--//
            else opt = managerMainMenu();
        } while(opt);
    }

    private boolean managerMainMenu() {
        printTitle("Main Menu");
        printMenuOptions(
                "Manager Dashboard",
                "Play Match",
                "Show Leagues",
                "Logout",
                "Exit");
        return managerMainMenuOptions(getIntUserInput("Select: "));
    }

    private boolean managerMainMenuOptions(int intUserInput) {
        switch (intUserInput) {
            case 1:{ // Manager Dashboard
                ManagerDashboard managerDashboard = new ManagerDashboard();
               manager =  managerDashboard.managerDashboard(manager);
                
                break;
            }
            case 2:{// Play Match
                //TODO: League sor ondan sonra mach menusune aktar!
                break;
            }
            case 3:{ //League Menu
                LeagueMenu.getInstance().leagueMenu(manager);
                break;
            }
            case 4:{ // Logout
                manager = Optional.empty();
                System.out.println("Logging out...");

                break;
            }
            case 5:{// Exit..
                printSuccessMessage("Gülü Gülü....");
                return false;
            }
        }
        return true;
    }

    private boolean anonymousMainMenu() {
        printTitle("Main Menu");
        printMenuOptions(
                "Manager Login",
                "Play Match",
                "League Menu",
                "Fedaration Login (In development...)",
                "Exit");
        return anonymousMainMenuOptions(getIntUserInput("Select: "));
    }

    private boolean anonymousMainMenuOptions(int intUserInput) {
        switch (intUserInput) {
            case 1:{ // Manager Login
                ManagerLoginRegister managerLoginRegister = ManagerLoginRegister.getInstance();
                manager = managerLoginRegister.loginRegisterMenu();
                break;
            }
            case 2:{// Play Match
                //TODO: League sor ondan sonra mach menusune aktar!
                break;
            }
            case 3:{ //League Menu
                LeagueMenu.getInstance().leagueMenu(manager);
                break;
            }
            case 4:{ // Federation login (In development...)
                System.out.println("In development...");
                break;
            }
            case 5:{// Exit..
                printSuccessMessage("Gülü Gülü....");
                return false;
            }
        }
        return true;
    }

}