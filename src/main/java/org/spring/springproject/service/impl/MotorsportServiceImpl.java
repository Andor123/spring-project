package org.spring.springproject.service.impl;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.spring.springproject.model.Motorsport;
import org.spring.springproject.repository.MotorsportRepository;
import org.spring.springproject.service.MotorsportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotorsportServiceImpl implements MotorsportService {
	
	@Autowired
	private MotorsportRepository repository;

	@Override
	public @NotNull List<Motorsport> getMotorsportResults() {
		final LocalDate today = LocalDate.now();
		final LocalDate fromDate = today.minusMonths(1);
		return repository.getMotorsportResultsFromDatabase(fromDate, today);
	}

	@Override
	public @NotNull List<Motorsport> getMotorsportFixtures() {
		final LocalDate today = LocalDate.now();
		final LocalDate toDate = today.plusMonths(1);
		return repository.getMotorsportFixturesFromDatabase(today, toDate);
	}

}
