package org.spring.springproject.service.impl;

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
		return repository.getMotorsportResultsFromDatabase();
	}

}
