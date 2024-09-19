package com.ajwalker.service;

import com.ajwalker.entity.Manager;
import com.ajwalker.repository.ICRUD;
import com.ajwalker.repository.LeagueRepository;
import com.ajwalker.repository.ManagerRepository;

public class ManagerService extends ServiceManager<Manager,Long>{
	public ManagerService() {
		super(ManagerRepository.getInstance());
	}
}