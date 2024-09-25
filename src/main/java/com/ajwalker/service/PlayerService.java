package com.ajwalker.service;

import com.ajwalker.entity.Player;
import com.ajwalker.entity.Team;
import com.ajwalker.repository.PlayerRepository;
import com.ajwalker.utility.ConsoleTextUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

import static com.ajwalker.utility.HibernateConnection.em;

public class PlayerService extends ServiceManager<Player,Long>{
	private static PlayerService instance;
	private final PlayerRepository playerRepository = PlayerRepository.getInstance();
	private PlayerService() {
		super(PlayerRepository.getInstance());
		
	}
	public static PlayerService getInstance() {
		if (instance == null) {
			instance = new PlayerService();
		}
		return instance;
	}


	public List<Player> makeAnOfferForPlayer(String nameToSearch){
        List<Player> playerList = new ArrayList<>();
        try {
            playerList = playerRepository.makeAnOfferForPlayer(nameToSearch);
            if(playerList.isEmpty()){
                System.out.println("No player found!");
                return new ArrayList<>();
            }
        } catch (Exception e) {
			ConsoleTextUtils.printErrorMessage("Service Error: "+e.getMessage());
        }
        return playerList;
	}


}