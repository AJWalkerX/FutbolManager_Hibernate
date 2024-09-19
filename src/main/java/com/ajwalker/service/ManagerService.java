package com.ajwalker.service;

import com.ajwalker.entity.Manager;
import com.ajwalker.repository.ICRUD;
import com.ajwalker.repository.LeagueRepository;
import com.ajwalker.repository.ManagerRepository;

public class ManagerService extends ServiceManager<Manager,Long>{
	private final ManagerRepository managerRepository;//
	
	public ManagerService() {
		this(new ManagerRepository());
	}
	
	public ManagerService(ManagerRepository managerRepository) {
		super(managerRepository);
		this.managerRepository = managerRepository;
	
	}
}