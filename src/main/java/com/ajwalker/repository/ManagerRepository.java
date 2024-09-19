package com.ajwalker.repository;

import com.ajwalker.entity.Manager;

public class ManagerRepository extends RepositoryManager<Manager,Long> {
	private static ManagerRepository instance;
	private ManagerRepository() {
		super(Manager.class);
	}
	public static ManagerRepository getInstance() {
		if (instance == null) {
			instance = new ManagerRepository();
		}
		return instance;
	}
}