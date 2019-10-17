package edu.mum.cs.cs425.mockFinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomepageController {

	@GetMapping(value={"/", "home"})
	public String homepage1() {
		return "homepage/index";
	}

}