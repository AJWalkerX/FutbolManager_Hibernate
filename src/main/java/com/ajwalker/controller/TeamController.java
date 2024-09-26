package com.ajwalker.controller;

import com.ajwalker.entity.League;
import com.ajwalker.entity.Team;
import com.ajwalker.service.TeamService;

import java.util.List;
import java.util.Optional;

public class TeamController{
	private static  TeamController instance;
	private TeamService teamService = TeamService.getInstance();
	private TeamController() {
	}
	public static TeamController getInstance() {
		if (instance == null) {
			instance = new TeamController();
		}
		return instance;
	}
	
	public Optional<Team> findById(Long id){
		return teamService.findById(id);
	}

	public List<Team> findAll(){
		return teamService.findAll();
	}

	public List<Team> findTeamsByLeague(League league) {
		return teamService.findByFieldNameAndValue("league",league);
	}


}