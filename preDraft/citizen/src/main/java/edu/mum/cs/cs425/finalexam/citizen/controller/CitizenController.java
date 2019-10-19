package edu.mum.cs.cs425.finalexam.citizen.controller;

import edu.mum.cs.cs425.finalexam.citizen.model.Citizen;
import edu.mum.cs.cs425.finalexam.citizen.model.State;
import edu.mum.cs.cs425.finalexam.citizen.service.CitizenService;
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
import java.util.List;

@Controller
@RequestMapping(value = {"/citizen"})
public class CitizenController {
    @Autowired
    private CitizenService citizenService;

    @Autowired
    private StateService stateService;

    @ModelAttribute("stateList") // validation error iin daraa combobox ruu list damjuulj bn
    public List<State> getStates(){
        return stateService.getAllState();
    }

    @GetMapping(value = {"/list"})
    public ModelAndView displayAllCitizen(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("citizenList", citizenService.getAllCitizen());
        modelAndView.setViewName("citizen/list");
        modelAndView.addObject("totalIncome", citizenService.computeIncome());
        return modelAndView;
    }

    @GetMapping(value = {"/register"})
    public String displayRegisterCitizenForm(Model model){
        model.addAttribute("citizen", new Citizen());
        model.addAttribute("stateList", stateService.getAllState());
        return "citizen/register";
    }

    @PostMapping(value = {"/register"})
    public String registerNewCitizen(@Valid @ModelAttribute("citizen") Citizen citizen,
                                     BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "citizen/register";
        }
        model.addAttribute("stateList", stateService.getAllState());
        citizen = citizenService.saveCitizen(citizen);
        return "redirect:/citizen/list";
    }




}
