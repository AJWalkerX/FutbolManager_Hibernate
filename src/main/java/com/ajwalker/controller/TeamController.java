package com.ajwalker.controller;

import com.ajwalker.entity.Team;
import com.ajwalker.service.TeamService;

public class TeamController extends ControllerManager<Team,Long>{
	private static  TeamController instance;
	private TeamController() {
		super(TeamService.getInstance());
	}
	public static TeamController getInstance() {
		if (instance == null) {
			instance = new TeamController();
		}
		return instance;
	}
}