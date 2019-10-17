package edu.mum.cs.cs425.demowebapps.goldendomemarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	
	@GetMapping(value = {"/"})
	public String displayHomePage() {
		return "home/index";
	}

}
