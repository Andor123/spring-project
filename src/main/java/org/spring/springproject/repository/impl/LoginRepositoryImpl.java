package org.spring.springproject.repository.impl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springproject.model.Login;
import org.spring.springproject.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Override
	public void save(@NotNull @Valid Login loginInfo) {
		logger.info("'save' {} now..." + loginInfo);
		
		final String sql = "INSERT INTO LOGIN (name, email, password) VALUES (?, ?, ?)";
		
		jdbctemplate.update(sql, loginInfo.getName(), loginInfo.getEmail(), loginInfo.getPassword());
	}

}
