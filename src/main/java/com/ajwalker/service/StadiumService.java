package com.ajwalker.service;

import com.ajwalker.entity.Stadium;
import com.ajwalker.repository.ICRUD;
import com.ajwalker.repository.StadiumRepository;

public class StadiumService extends ServiceManager<Stadium,Long>{
	public StadiumService() {
		super(StadiumRepository.getInstance());
	}
}