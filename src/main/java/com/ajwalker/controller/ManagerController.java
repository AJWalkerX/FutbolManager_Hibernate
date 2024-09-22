package com.ajwalker.controller;

import com.ajwalker.entity.Manager;
import com.ajwalker.service.ManagerService;

import java.util.Optional;

public class ManagerController extends ControllerManager<Manager,Long>{
	private static ManagerController instance;
	private static ManagerService managerService = ManagerService.getInstance();
	private ManagerController() {
		super(managerService);
	}
	public static ManagerController getInstance() {
		if (instance == null) {
			instance = new ManagerController();
		}
		return instance;
	}

    public Optional<Manager> findByUsernameAndPassword(String username, String password) {
		try {
			return managerService.findByUsernameAndPassword(username,password);

		}catch (Exception e) {
			System.out.println("Controller Error: "+ e.getMessage());
			return Optional.empty();
		}
    }
}