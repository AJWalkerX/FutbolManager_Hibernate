package com.ajwalker.service;

import com.ajwalker.entity.Manager;
import com.ajwalker.repository.ManagerRepository;

public class ManagerService extends ServiceManager<Manager,Long>{
	private static ManagerService instance;
	private ManagerService() {
		super(ManagerRepository.getInstance());
	}
	public static ManagerService getInstance() {
		if (instance == null) {
			instance = new ManagerService();
		}
		return instance;
	}
}