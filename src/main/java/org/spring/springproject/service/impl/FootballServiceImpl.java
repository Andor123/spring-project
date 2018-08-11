package org.spring.springproject.service.impl;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.spring.springproject.model.Football;
import org.spring.springproject.repository.FootballRepository;
import org.spring.springproject.service.FootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FootballServiceImpl implements FootballService {
	
	@Autowired
	private FootballRepository repository;

	@Override
	public @NotNull List<Football> getFootballResults() {
		return repository.getFootballResultsFromDatabase();
	}

}
