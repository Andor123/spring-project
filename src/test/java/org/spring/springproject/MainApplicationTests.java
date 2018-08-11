package org.spring.springproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springproject.model.Login;
import org.spring.springproject.service.LoginService;
import org.spring.springproject.service.exception.LoginAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainApplicationTests {
	
	@Autowired
	private LoginService service;
	
	@Test
	public void test_registrationWithValidLogin_successfull() throws LoginAlreadyExistsException {
		
		service.login(new Login("Salamon Andor", "salamon.andor@gmail.com", "salamonandor1995"));
		
	}

}
