package org.spring.springproject.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.spring.springproject.model.Basketball;
import org.springframework.validation.annotation.Validated;

@Validated
public interface BasketballRepository {

	@NotNull
	List<Basketball> getBasketballResultsFromDatabase();
	
}
