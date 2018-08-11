package org.spring.springproject.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.spring.springproject.model.Basketball;
import org.springframework.validation.annotation.Validated;

@Validated
public interface BasketballService {
	
	@NotNull
	List<Basketball> getBasketballResults();

}
