package org.spring.springproject.repository;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.spring.springproject.model.Basketball;
import org.springframework.validation.annotation.Validated;

@Validated
public interface BasketballRepository {

	@NotNull
	List<Basketball> getBasketballResultsFromDatabase(@NotNull LocalDate fromTime, @NotNull LocalDate toTime);
	
	@NotNull
	List<Basketball> getBasketballFixturesFromDatabase(@NotNull LocalDate fromTime, @NotNull LocalDate toTime);
	
}
