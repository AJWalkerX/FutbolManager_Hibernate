package com.ajwalker.controller;

import com.ajwalker.entity.Team;
import com.ajwalker.service.TeamService;

public class TeamController{
	private static  TeamController instance;
	private TeamController() {
	}
	public static TeamController getInstance() {
		if (instance == null) {
			instance = new TeamController();
		}
		return instance;
	}
}