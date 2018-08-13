package org.spring.springproject.service.impl;

import java.time.LocalDate;
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
		final LocalDate today = LocalDate.now();
		final LocalDate fromDate = today.minusWeeks(1);
		return repository.getFootballResultsFromDatabase(fromDate, today);
	}

	@Override
	public @NotNull List<Football> getFootballFixtures() {
		final LocalDate today = LocalDate.now();
		final LocalDate toDate = today.plusWeeks(1);
		return repository.getFootballFixturesFromDatabase(today, toDate);
	}

}
