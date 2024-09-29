package com.ajwalker.gui.iddaa_gui;

import com.ajwalker.entity.Gambler;
import com.ajwalker.repository.GamblerRepository;

import static com.ajwalker.utility.ConsoleTextUtils.*;

import java.util.Optional;

public class IddaaMenu {
    private Gambler gambler;
    private GamblerRepository gamblerRepository = GamblerRepository.getInstance();

    public void iddaaMenu() {
        boolean opt = true;
        while (opt) {
            opt = loginRegisterMenu();
        }
    }

    private boolean loginRegisterMenu() {
        printMenuOptions("Login", "Register", "Return To Main Menu");
        return loginRegisterMenuOptions(getIntUserInput("Select: "));

    }

    private boolean loginRegisterMenuOptions(int userInput) {
        switch (userInput) {
            case 1:
                Optional<Gambler> gamblerOptional = loginGambler();
                if (gamblerOptional.isPresent()) {
                    gambler = gamblerOptional.get();
                    return oynaKazanMenu();
                }

                break;
            case 2:
                //todo: gamblerRegister():
                break;
            case 3:
                return false;
        }
        return true;
    }

    private Optional<Gambler> loginGambler() {
        String username  = getStringUserInput("Username: ");
        String password = getStringUserInput("Password: ");
        return gamblerRepository.findByUsernameAndPassword(username, password);
    }

    private boolean oynaKazanMenu(){
        printMenuOptions("Place a bet","List my previous bets","Return To Main Menu");
        int selection = getIntUserInput("Selection: ");
        switch (selection){
            case 1:
                //Kupon oynama
                oynaKazanMenu();
                break;
            case 2:
                //kumarbazın geçmiş kuponlarını listele
                oynaKazanMenu();
                break;
        }
        return false;
    }

    private void placeBet(){

    }


}
