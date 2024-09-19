package com.ajwalker.service;

import com.ajwalker.entity.Stadium;
import com.ajwalker.repository.ICRUD;

public class StadiumService extends ServiceManager<Stadium,Long>{//
	public StadiumService(ICRUD<Stadium, Long> repository) {
		super(repository);
	}
}