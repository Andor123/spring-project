package org.spring.springproject.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springproject.model.Login;
import org.spring.springproject.service.LoginService;
import org.spring.springproject.service.exception.LoginAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	private static final String LOGIN_FORM = "login";

	private static final String LOGIN_FORM_ATTRIBUTE = "loginForm";

	private static final String PATH_LOGIN = "/login";

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping(value = {"/", PATH_LOGIN})
	public String getLogin(@ModelAttribute(LOGIN_FORM_ATTRIBUTE) Login l) {
		return LOGIN_FORM;
	}
	
	@PostMapping(PATH_LOGIN)
	public String submitLogin(@ModelAttribute(LOGIN_FORM_ATTRIBUTE) @Valid Login login, 
			BindingResult result, HttpServletResponse response) throws LoginAlreadyExistsException {
		logger.debug("user login to app: {}", login);
		if (result.hasErrors()) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			return LOGIN_FORM;
		} else {
			loginService.login(login);
			return "redirect:/main";
		}
	}
	
}
