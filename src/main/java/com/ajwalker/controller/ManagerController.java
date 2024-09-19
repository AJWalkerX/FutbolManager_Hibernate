package com.ajwalker.controller;

import com.ajwalker.entity.Manager;
import com.ajwalker.service.ManagerService;

public class ManagerController extends ControllerManager<Manager,Long>{
	private static ManagerController instance;
	private ManagerController() {
		super(ManagerService.getInstance());
	}
	public static ManagerController getInstance() {
		if (instance == null) {
			instance = new ManagerController();
		}
		return instance;
	}
}