package org.spring.springproject;

import javax.validation.ConstraintViolationException;

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
public class LoginValidationTests {

	@Autowired
	private LoginService service;
	
	@Test(expected = ConstraintViolationException.class)
	public void test_registrationWithNullLogin_fails() throws LoginAlreadyExistsException {
		
		service.login(null);
		
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void test_registrationWithNameOfSpaceOnly_fails() throws LoginAlreadyExistsException {
		
		service.login(new Login(" ", "salamon.andor@gmail.com", "salamonandor1995"));
		
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void test_registrationWithInvalidEmailFormat_fails() throws LoginAlreadyExistsException {
		
		service.login(new Login("Salamon Andor", "gmail.com", "salamonandor1995"));
		
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void test_registrationWithShortPassword_fails() throws LoginAlreadyExistsException {
		
		service.login(new Login("Salamon Andor", "gmail.com", "s1995"));
		
	}

}
