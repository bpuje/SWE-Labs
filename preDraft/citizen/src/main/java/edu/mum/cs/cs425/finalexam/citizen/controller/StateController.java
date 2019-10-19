package edu.mum.cs.cs425.finalexam.citizen.controller;

import edu.mum.cs.cs425.finalexam.citizen.model.State;
import edu.mum.cs.cs425.finalexam.citizen.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/state"})
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping(value = {"/list"})
    public ModelAndView displayAllState(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("stateList", stateService.getAllState());
        modelAndView.setViewName("state/list");
        return modelAndView;
    }

    @GetMapping(value = "/register")
    public String displayNewStateRegisterForm(Model model){
        model.addAttribute("state", new State());
        return "state/register";
    }


    @PostMapping(value = "/register")
    public String registerNewState(@Valid @ModelAttribute("state") State state,
                                   BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "state/register";
        }
        state = stateService.saveState(state);
        return "redirect:/state/list";
    }

}
