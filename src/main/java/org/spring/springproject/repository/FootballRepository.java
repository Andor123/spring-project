package org.spring.springproject.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.spring.springproject.model.Football;
import org.springframework.validation.annotation.Validated;

@Validated
public interface FootballRepository {
	
	@NotNull
	List<Football> getFootballResultsFromDatabase();

}
