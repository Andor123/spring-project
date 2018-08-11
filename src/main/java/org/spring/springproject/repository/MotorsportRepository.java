package org.spring.springproject.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.spring.springproject.model.Motorsport;
import org.springframework.validation.annotation.Validated;

@Validated
public interface MotorsportRepository {

	@NotNull
	List<Motorsport> getMotorsportResultsFromDatabase();
	
}
