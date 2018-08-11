package org.spring.springproject.controller;

import org.spring.springproject.service.MotorsportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MotorsportController {
	
	@Autowired
	private MotorsportService motorsportService;

	@GetMapping("/motorsport")
	public String getMotorsport(Model model) {
		model.addAttribute("motorsportResults", motorsportService.getMotorsportResults());
		return "motorsport";
	}
	
}
