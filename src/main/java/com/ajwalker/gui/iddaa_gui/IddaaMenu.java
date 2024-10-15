package com.ajwalker.gui.iddaa_gui;

import com.ajwalker.entity.*;
import com.ajwalker.model.BetModel;
import com.ajwalker.model.BetOddsModel;
import com.ajwalker.model.GamblerModel;
import com.ajwalker.repository.GamblerRepository;
import com.ajwalker.service.BetOddsService;
import com.ajwalker.service.BetSelectionService;
import com.ajwalker.service.BetService;
import com.ajwalker.service.MatchService;
import com.ajwalker.utility.enums.EBetState;
import com.ajwalker.utility.enums.EOddSelection;

import static com.ajwalker.utility.ConsoleTextUtils.*;

import java.math.BigDecimal;
import java.util.*;

public class IddaaMenu {
    private Gambler gambler;
    private GamblerRepository gamblerRepository = GamblerRepository.getInstance();
    private MatchService matchService = MatchService.getInstance();
    private BetOddsService betOddsService = BetOddsService.getInstance();
    private BetService betService = BetService.getInstance();
    private BetSelectionService betSelectionService = BetSelectionService.getInstance();

    private Bet bet;
    private Map<BetOdds, EOddSelection> selectionMap;


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
        bet = Bet.builder()
                .betState(EBetState.ON_WAIT).totalBetOdd(BigDecimal.valueOf(1.0))
                .build();
        selectionMap = new HashMap<>();

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
        String username = getStringUserInput("Username:");
        String password = getStringUserInput("Password:");
        return gamblerRepository.findByUsernameAndPassword(username, password);
    }

    private boolean oynaKazanMenu() {


        printMenuOptions("Add a match to your bet",
                "Preview your current bet",
                "Place your bet",
                "List my previous bets",
                "Return To Main Menu");
        int selection = getIntUserInput("Selection:");
        switch (selection) {
            case 1:
                BetOdds betOdds = selectAMatchToPlaceBet();
                addBetOdds(betOdds);
                oynaKazanMenu();
                break;
            case 2:
                new BetModel(bet,selectionMap).displayMyBet();
                oynaKazanMenu();
                    break;
            case 3:
                placeBet();
                oynaKazanMenu();
                break;
            case 4:
                new GamblerModel(gambler).displayMyPreviousBets();
                oynaKazanMenu();
                break;
        }
        return false;
    }

    private BetOdds selectAMatchToPlaceBet() {
        List<Match> matches = matchService.getCurrentWeeksFixture();
        List<BetOdds> betOddsListByMatches = betOddsService.getBetOddsListByMatches(matches);
        int counter = 0;
        for (BetOdds betOdds : betOddsListByMatches) {
            System.out.print(++counter + ".");
            new BetOddsModel(betOdds).displayHomeTeamAndAwayTeamsName();
        }

        int selection = getIntUserInput("Select a match number to place a bet: ");
        if (selection > 0 && selection <= betOddsListByMatches.size()) {
            return betOddsListByMatches.get(selection - 1);
        }
        System.out.println("Invalid choice. Please try again later.");
        return null;
    }

    //HOME_TEAM_WINS,AWAY_TEAM_WINS,DRAW,UST,ALT
    private void addBetOdds(BetOdds betOdds) {
        new BetOddsModel(betOdds).displayBetOdd();
        int selection = getIntUserInput("Selection:");
        betService.addOddsToBet(bet, betOdds, selection,selectionMap);
    }

    private void placeBet(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an amount to bet: ");
        Double amountToBet = sc.nextDouble();
        sc.nextLine();
        if(amountToBet>0 && gambler.getAccountBalance()>amountToBet){
            bet.setBetAmount(BigDecimal.valueOf(amountToBet));
            betService.save(bet);
           selectionMap.forEach((k,v)->{
               BigDecimal betOdd = betService.getSelectedBetOdd(k,v);
               BetSelectionMap bsm = BetSelectionMap.builder()
                       .bet_id(bet.getId())
                       .betOdd(betOdd)
                       .betOdds_id(k.getId())
                       .oddSelection(v)
                       .build();
               betSelectionService.save(bsm);
           });
           gambler.getBetList().add(bet);
            System.out.println("You have successfully placed your bet!");
            new BetModel(bet,selectionMap).displayMyBet();
            bet = Bet.builder()
                    .betState(EBetState.ON_WAIT).totalBetOdd(BigDecimal.valueOf(1.0)).build();

        }
    }


}
