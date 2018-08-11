package org.spring.springproject.service.impl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springproject.model.Login;
import org.spring.springproject.repository.LoginRepository;
import org.spring.springproject.service.LoginService;
import org.spring.springproject.service.exception.LoginAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private LoginRepository repository;
	
	@Override
	public void login(@NotNull @Valid Login loginInfo) throws LoginAlreadyExistsException {
		logger.info("Login: {}", loginInfo);
		try {
			repository.save(loginInfo);
		} catch (DuplicateKeyException duplicate) {
			throw new LoginAlreadyExistsException("Login already exists with this email: " + loginInfo.getEmail());
		}
	}

}
