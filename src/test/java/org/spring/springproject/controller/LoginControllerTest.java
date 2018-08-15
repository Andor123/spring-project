package org.spring.springproject.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
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
	private static final String VIEW_LOGIN_DUPLICATE = "error/error-login-already-exists";

	private static final String CONTENTTYPE_HTML_UTF8 = "text/html;charset=UTF-8";

	private static final String PATH_LOGIN_FORM = "/login";
	private static final String PATH_MAIN_FORM = "/main";

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
	
	private void when_userSubmitsLoginFormContaining(final Login loginInput) throws Exception {
		result = mvc.perform(
				post(PATH_LOGIN_FORM)
				.accept(MediaType.TEXT_HTML)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param(FORM_FIELD_NAME, loginInput.getName())
				.param(FORM_FIELD_EMAIL, loginInput.getEmail())
				.param(FORM_FIELD_PASSWORD, loginInput.getPassword()));
	}
	
	private void then_theUserIsRedirectedToTheMainPage() throws Exception {
		result.andDo(print())
		.andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl(PATH_MAIN_FORM));
	}
	
	@Test
	public void testLoginFormTakesCorrectlySubmittedData() throws Exception {
		given_theUserIsOnTheLoginPage();
		Login validLogin = new Login("Salamon Andor", "salamon.andor@gmail.com", "salamonandor1995");
		when_userSubmitsLoginFormContaining(validLogin);
		then_loginIsSentToTheService(validLogin);
		then_theUserIsRedirectedToTheMainPage();
	}
	
	private void then_theRegistrationIsRefusedDueToBadRequest() throws Exception {
		result.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(xpath("//div[@class='formErrorMessage']").exists());
	}
	
	private void then_fieldErrorDisplayedFor(String fieldName) throws Exception {
		result.andExpect(xpath("//div[@class='fieldErrorMessage']/following-sibling::*[position()=1][@name='" + fieldName + "']").exists());
	}
	
	private void then_fieldErrorNotDisplayedFor(String fieldName) throws Exception {
		result.andExpect(xpath("//div[@class='fieldErrorMessage']/following-sibling::*[position()=1][@name='" + fieldName + "']").doesNotExist());
	}
	
	@Test
	public void testLoginFormRefusesInputWithMissingName() throws Exception {
		given_theUserIsOnTheLoginPage();
		final Login loginWithMissingName = new Login("", "salamon.andor@gmail.com", "salamonandor1995");
		when_userSubmitsLoginFormContaining(loginWithMissingName);
		then_theRegistrationIsRefusedDueToBadRequest();
		then_fieldErrorDisplayedFor(FORM_FIELD_NAME);
		then_fieldErrorNotDisplayedFor(FORM_FIELD_EMAIL);
		then_fieldErrorNotDisplayedFor(FORM_FIELD_PASSWORD);
		then_theFormContains(loginWithMissingName);
		then_loginIsNotSentToTheService();
	}
	
	private void then_loginIsSentToTheService(final Login login) throws LoginAlreadyExistsException {
		verify(loginService, times(1)).login(login);
	}
	
	private void then_loginIsNotSentToTheService() throws LoginAlreadyExistsException {
		verify(loginService, times(0)).login(any());
	}
	
	private void given_aLoginAlreadyExistsWith(String alreadyExistingEmail) throws LoginAlreadyExistsException {
		doThrow(new LoginAlreadyExistsException(null))
		.when(loginService)
		.login(argThat(login -> login.getEmail().equals(alreadyExistingEmail)));
	}
	
	private void then_theUserSeesThatTheEmailAlreadyRegistered() throws Exception {
		result.andDo(print())
		.andExpect(status().isConflict())
		.andExpect(view().name(VIEW_LOGIN_DUPLICATE));
	}
	
	@Test
	public void testLoginRefusedDueToDuplication() throws Exception {
		final Login duplicateLogin = new Login("Salamon Andor", "salamon.andor@gmail.com", "salamonandor1995");
		given_theUserIsOnTheLoginPage();
		given_aLoginAlreadyExistsWith(duplicateLogin.getEmail());
		when_userSubmitsLoginFormContaining(duplicateLogin);
		then_loginIsSentToTheService(duplicateLogin);
		then_theUserSeesThatTheEmailAlreadyRegistered();
	}

}
