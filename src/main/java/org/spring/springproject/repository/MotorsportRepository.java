package org.spring.springproject.repository;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.spring.springproject.model.Motorsport;
import org.springframework.validation.annotation.Validated;

@Validated
public interface MotorsportRepository {

	@NotNull
	List<Motorsport> getMotorsportResultsFromDatabase(@NotNull LocalDate fromTime, @NotNull LocalDate toTime);
	
	@NotNull
	List<Motorsport> getMotorsportFixturesFromDatabase(@NotNull LocalDate fromTime, @NotNull LocalDate toTime);
	
}
