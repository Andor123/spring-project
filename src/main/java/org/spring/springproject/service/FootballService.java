package org.spring.springproject.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.spring.springproject.model.Football;
import org.springframework.validation.annotation.Validated;

@Validated
public interface FootballService {
	
	@NotNull
	List<Football> getFootballResults();
	
	@NotNull
	List<Football> getFootballFixtures();

}
