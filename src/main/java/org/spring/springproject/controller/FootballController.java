package org.spring.springproject.controller;

import org.spring.springproject.service.FootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FootballController {
	
	@Autowired
	private FootballService footballService;
	
	@GetMapping("/football")
	public String getFootball(Model model) {
		model.addAttribute("footballResults", footballService.getFootballResults());
		model.addAttribute("footballFixtures", footballService.getFootballFixtures());
		return "football";
	}
	
}
