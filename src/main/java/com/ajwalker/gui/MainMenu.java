package com.ajwalker.gui;

import java.util.Optional;

public class MainMenu {

    private static MainMenu instance = new MainMenu();

    public static MainMenu getInstance() {
        return instance;
    }

    private Optional<String> managerUsername = Optional.empty();

    public void mainMenu(){
        int opt;
//        do{
//            if (managerUsername.isEmpty()) opt = anonymousMainMenu();
//            else opt = userMainMenu();
//        } while(opt != 0);
//        System.out.println(opt);
    }
}
