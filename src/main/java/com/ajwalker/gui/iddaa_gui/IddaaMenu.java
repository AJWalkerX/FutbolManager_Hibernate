package com.ajwalker.gui.iddaa_gui;

import com.ajwalker.entity.Bet;
import com.ajwalker.entity.BetOdds;
import com.ajwalker.entity.Gambler;
import com.ajwalker.entity.Match;
import com.ajwalker.model.BetOddsModel;
import com.ajwalker.repository.GamblerRepository;
import com.ajwalker.service.BetOddsService;
import com.ajwalker.service.MatchService;
import com.ajwalker.utility.enums.EBetState;

import static com.ajwalker.utility.ConsoleTextUtils.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IddaaMenu {
    private Gambler gambler;
    private GamblerRepository gamblerRepository = GamblerRepository.getInstance();
    private MatchService matchService = MatchService.getInstance();
    private BetOddsService betOddsService = BetOddsService.getInstance();
    private Bet bet;

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
        String username  = getStringUserInput("Username:");
        String password = getStringUserInput("Password:");
        return gamblerRepository.findByUsernameAndPassword(username, password);
    }

    private boolean oynaKazanMenu(){
        printMenuOptions("Place a new bet","List my previous bets","Return To Main Menu");
        int selection = getIntUserInput("Selection:");
        switch (selection){
            case 1:
                bet = Bet.builder().betOdds(new ArrayList<>()
                ).betState(EBetState.ON_WAIT).totalBetOdd(BigDecimal.ZERO).build();
                BetOdds betOdds = selectAMatchToPlaceBet();
                addBetOdds(betOdds);
                //Burdan devam edilecek. Kullanıcı maç için tahminde bulundduktan sonra o tahmini
                // hafızada nasıl tutabilirsin onu düşün. belki enum ile.ESelection gibi.
                oynaKazanMenu();
                break;
            case 2:
                //kumarbazın geçmiş kuponlarını listele
                oynaKazanMenu();
                break;
        }
        return false;
    }

    private BetOdds selectAMatchToPlaceBet(){
        List<Match> matches  = matchService.getWeeklyFixture();
        List<BetOdds> betOddsListByMatches = betOddsService.getBetOddsListByMatches(matches);
        int counter =0;
        for (BetOdds betOdds : betOddsListByMatches) {
            System.out.print(++counter+".");
            new BetOddsModel(betOdds).displayHomeTeamAndAwayTeamsName();
        }

        int selection = getIntUserInput("Select a match number to place a bet: ");
        if(selection>0 && selection<=betOddsListByMatches.size()){
            return betOddsListByMatches.get(selection-1);
        }
        System.out.println("Invalid choice. Please try again later.");
        return null;
    }

    private void addBetOdds(BetOdds betOdds){
        new BetOddsModel(betOdds).displayBetOdd();
    }


}
