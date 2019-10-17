package edu.mum.cs.cs425.demowebapps.goldendomemarket.controller;

import edu.mum.cs.cs425.demowebapps.goldendomemarket.model.Citizen;
import edu.mum.cs.cs425.demowebapps.goldendomemarket.model.State;
import edu.mum.cs.cs425.demowebapps.goldendomemarket.service.CitizenService;
import edu.mum.cs.cs425.demowebapps.goldendomemarket.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CitizenController {


	@Autowired
	private CitizenService citizenService;

	@Autowired
	private StateService stateService;

	@GetMapping(value = {"/citizen/register"})
	public String showNewCitizenRegisterForm(Model model) {
		List<State> states = stateService.getAllState();
		model.addAttribute("states", states);
		model.addAttribute("citizen", new Citizen());
		return "citizen/register";
	}
	@PostMapping(value = {"/citizen/register"})
	public String registerNewCitizen(@Valid @ModelAttribute("citizen") Citizen citizen,
									 BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "citizen/register";
		}
		List<State> states = stateService.getAllState();
		model.addAttribute("states", states);

		citizen = citizenService.registerNewCitizen(citizen);
		return "redirect:/citizen/list";
	}

	@GetMapping(value = {"/citizen/list"})
	public ModelAndView showCitizensListForm(@RequestParam(defaultValue = "0")int pageNo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("citizens", citizenService.getAllCitizenPaged(pageNo));
		modelAndView.addObject("netAmount", citizenService.totalNetYearIncome());
		modelAndView.addObject("currentPageNo", pageNo); //current page no
		modelAndView.setViewName("citizen/list");
		return modelAndView;
	}

	@GetMapping(value = {"/citizen/edit/{citizenId}"})
	public String studentEditForm(@PathVariable Integer citizenId, Model model) {
		Citizen citizen = citizenService.getCitizenById(citizenId);
		if (citizen != null) {
			model.addAttribute("citizen", citizen);
			return "citizen/edit";
		}
		return "citizen/list";
	}

	@PostMapping(value = {"/citizen/edit"})
	public String updateCitizen(@Valid @ModelAttribute("citizen") Citizen citizen,
								BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "citizen/edit";
		}
		citizen = citizenService.saveCitizen(citizen);
		return "redirect:/citizen/list";
	}



}
