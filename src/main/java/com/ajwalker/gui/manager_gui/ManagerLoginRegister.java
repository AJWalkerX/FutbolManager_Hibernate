package com.ajwalker.gui.manager_gui;

import com.ajwalker.controller.ManagerController;
import com.ajwalker.entity.Manager;
import com.ajwalker.gui.MainMenu;
import static com.ajwalker.utility.ConsoleTextUtils.*;

import java.util.Optional;

public class ManagerLoginRegister {
    private static ManagerLoginRegister instance;
    private ManagerLoginRegister(){}
    public static ManagerLoginRegister getInstance() {
        if (instance == null) {
            instance = new ManagerLoginRegister();
        }
        return instance;
    }

    public Optional<Manager> loginRegisterMenu() {
        printTitle("Manager Login Menu");
        printMenuOptions("Register", "Login");
        return loginRegisterMenuOptions(getIntUserInput("Select: "));
    }

    private Optional<Manager> loginRegisterMenuOptions(int intUserInput) {
        switch (intUserInput) {
            case 1:{ // TODO: Daha sonra yapılacak!
                break;
            }
            case 2:{
                return loginManager();
            }
        }
        return Optional.empty();
    }

    private Optional<Manager> loginManager() {
        for (int i = 2; i >= 0; i--){
            ManagerController managerController = ManagerController.getInstance();
            String username = getStringUserInput("username: ");
            String password = getStringUserInput("password: ");
            Optional<Manager> manager = managerController.findByUsernameAndPassword(username, password);
            if (manager.isPresent()) {
                return manager;
            }
            printErrorMessage(i + " login chance left");
        }
        printErrorMessage("Please try again later!");
        return Optional.empty();
    }
}
