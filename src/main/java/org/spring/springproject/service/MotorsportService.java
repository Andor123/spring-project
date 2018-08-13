package org.spring.springproject.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.spring.springproject.model.Motorsport;
import org.springframework.validation.annotation.Validated;

@Validated
public interface MotorsportService {
	
	@NotNull
	List<Motorsport> getMotorsportResults();
	
	@NotNull
	List<Motorsport> getMotorsportFixtures();

}
