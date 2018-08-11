package org.spring.springproject.controller;

import org.spring.springproject.service.BasketballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasketballController {
	
	@Autowired
	private BasketballService basketballService;

	@GetMapping("/basketball")
	public String getBasketball(Model model) {
		model.addAttribute("basketballResults", basketballService.getBasketballResults());
		return "basketball";
	}
	
}
