package com.ajwalker.service;

import com.ajwalker.controller.TeamController;
import com.ajwalker.entity.ContractOffer;
import com.ajwalker.entity.Player;
import com.ajwalker.entity.Team;
import com.ajwalker.entity.Transfer;
import com.ajwalker.repository.ICRUD;
import com.ajwalker.repository.TransferRepository;

import java.util.List;

public class TransferService extends ServiceManager<Transfer, Long> {
    private static TransferService instance;
    private static TransferRepository transferRepository = TransferRepository.getInstance();

    private TransferService() {
        super(TransferRepository.getInstance());
    }

    public static TransferService getInstance() {
        if (instance == null) {
            instance = new TransferService();
        }
        return instance;
    }

    public void finalizeTransfer(ContractOffer contractOffer) {
        Transfer transfer = Transfer.builder()
                .contractOffer(contractOffer).build();
        Player player = transfer.getContractOffer().getTransferOffer().getPlayer();
        Team newTeamOfPlayer = transfer.getContractOffer().getTransferOffer().getProposer();
        Team oldTeamOfPlayer = transfer.getContractOffer().getTransferOffer().getReceiver();
        System.out.println(player.getName() + " has joined to " + newTeamOfPlayer.getTeamName() + " from " + oldTeamOfPlayer.getTeamName());


        Long biddingMoney = contractOffer.getTransferOffer().getBiddingMoney();

        player.setTeam(newTeamOfPlayer);
        oldTeamOfPlayer.setBudget(oldTeamOfPlayer.getBudget() + biddingMoney);
        newTeamOfPlayer.setBudget(newTeamOfPlayer.getBudget() - biddingMoney);

        newTeamOfPlayer.getPlayers().add(player);
        oldTeamOfPlayer.getPlayers().remove(player);
        TeamService.getInstance().updateAll(List.of(newTeamOfPlayer, oldTeamOfPlayer));
        PlayerService.getInstance().update(player);


        transferRepository.save(transfer);
    }

}
