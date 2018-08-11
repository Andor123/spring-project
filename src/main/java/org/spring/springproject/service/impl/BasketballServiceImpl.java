package org.spring.springproject.service.impl;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.spring.springproject.model.Basketball;
import org.spring.springproject.repository.BasketballRepository;
import org.spring.springproject.service.BasketballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketballServiceImpl implements BasketballService {
	
	@Autowired
	private BasketballRepository repository;

	@Override
	public @NotNull List<Basketball> getBasketballResults() {
		return repository.getBasketballResultsFromDatabase();
	}

}
