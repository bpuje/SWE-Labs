package edu.mum.cs.cs425.demowebapps.goldendomemarket.controller;

import edu.mum.cs.cs425.demowebapps.goldendomemarket.model.State;
import edu.mum.cs.cs425.demowebapps.goldendomemarket.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StateController {

	@Autowired
	private StateService stateService;

	@GetMapping(value = {"/state/register"})
	public String showNewStudentRegisterForm(Model model) {
		model.addAttribute("state", new State());
		return "state/register";
	}
	@PostMapping(value = {"/state/register"})
	public String registerNewStudent(@Valid @ModelAttribute("state") State state,
									 BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "state/register";
		}
		state = stateService.registerNewState(state);
		return "redirect:/state/list";
	}

	@GetMapping(value = {"/state/list"})
	public ModelAndView showStudentsListForm(@RequestParam(defaultValue = "0")int pageNo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("states", stateService.getAllStatePaged(pageNo));
		modelAndView.addObject("currentPageNo", pageNo); //current page no
		modelAndView.setViewName("state/list");
		return modelAndView;
	}




}
