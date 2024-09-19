package com.ajwalker.repository;

import com.ajwalker.entity.Stadium;

public class StadiumRepository extends RepositoryManager<Stadium,Long>{
	public StadiumRepository() {
		super(Stadium.class);
	}
}