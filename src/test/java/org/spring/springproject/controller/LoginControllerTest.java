package org.spring.springproject.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springproject.model.Login;
import org.spring.springproject.service.LoginService;
import org.spring.springproject.service.exception.LoginAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
public class LoginControllerTest {
	
	private static final String FORM_FIELD_PASSWORD = "password";
	private static final String FORM_FIELD_EMAIL = "email";
	private static final String FORM_FIELD_NAME = "name";

	private static final String VIEW_LOGIN_FORM = "login";

	private static final String CONTENTTYPE_HTML_UTF8 = "text/html;charset=UTF-8";

	private static final String PATH_LOGIN_FORM = "/login";

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private LoginService loginService;
	
	private ResultActions result;
	
	private void given_theUserIsOnTheLoginPage() throws Exception {
		result = mvc.perform(
				get(PATH_LOGIN_FORM)
				.accept(MediaType.TEXT_HTML)
				.locale(Locale.ENGLISH))
				.andDo(print())
				.andExpect(content().contentType(CONTENTTYPE_HTML_UTF8))
				.andExpect(status().isOk())
				.andExpect(view().name(VIEW_LOGIN_FORM));
	}
	
	private void then_theFormContains(final Login login) throws Exception {
		result.andExpect(xpath("//input[@name='" + FORM_FIELD_NAME + "']/@value").string(login.getName()))
		.andExpect(xpath("//input[@name='" + FORM_FIELD_EMAIL + "']/@value").string(login.getEmail()))
		.andExpect(xpath("//input[@name='" + FORM_FIELD_PASSWORD + "']/@value").string(login.getPassword()));
	}
	
	@Test
	public void testLoginFormIsEmptyWhenLoginFormIsOpened() throws Exception {
		given_theUserIsOnTheLoginPage();
		then_theFormContains(new Login("", "", ""));
		then_loginIsNotSentToTheService();
	}
	
	private void then_loginIsNotSentToTheService() throws LoginAlreadyExistsException {
		verify(loginService, times(0)).login(any());
	}

}
