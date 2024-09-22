package com.ajwalker.gui;

import com.ajwalker.entity.Manager;
import com.ajwalker.gui.manager_gui.ManagerLoginRegister;

import java.util.Optional;
import static com.ajwalker.utility.ConsoleTextUtils.*;


public class MainMenu {
    private Optional<Manager> manager = Optional.empty();
    private final int starSize = 50;
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
        printTitle(starSize,"Main Menu");
        printMenuOptions(starSize,
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

                break;
            }
            case 2:{// Play Match
                //TODO: League sor ondan sonra mach menusune aktar!
                break;
            }
            case 3:{ //Show Leagues
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
        printTitle(starSize,"Main Menu");
        printMenuOptions(starSize,
                "Manager Login",
                "Play Match",
                "Show Leagues",
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
            case 3:{ //Show Leagues
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
