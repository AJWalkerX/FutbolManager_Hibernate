package com.ajwalker.repository;

import com.ajwalker.entity.Manager;

public class ManagerRepository extends RepositoryManager<Manager,Long> {
	public ManagerRepository() {
		super(Manager.class);
	}
}