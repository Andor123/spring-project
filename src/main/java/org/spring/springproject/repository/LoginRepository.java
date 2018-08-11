package org.spring.springproject.repository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.spring.springproject.model.Login;
import org.springframework.validation.annotation.Validated;

@Validated
public interface LoginRepository {
	
	void save(@NotNull @Valid Login loginInfo);

}
