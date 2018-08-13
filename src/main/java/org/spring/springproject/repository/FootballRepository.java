package org.spring.springproject.repository;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.spring.springproject.model.Football;
import org.springframework.validation.annotation.Validated;

@Validated
public interface FootballRepository {
	
	@NotNull
	List<Football> getFootballResultsFromDatabase(@NotNull LocalDate fromTime, @NotNull LocalDate toTime);
	
	@NotNull
	List<Football> getFootballFixturesFromDatabase(@NotNull LocalDate fromTime, @NotNull LocalDate toTime);

}
