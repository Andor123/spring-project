package org.spring.springproject.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.spring.springproject.model.Login;
import org.spring.springproject.service.exception.LoginAlreadyExistsException;
import org.springframework.validation.annotation.Validated;

@Validated
public interface LoginService {
	
	void login(@NotNull @Valid Login loginInfo) throws LoginAlreadyExistsException;
	
}
