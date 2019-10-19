package edu.mum.cs.cs425.midten.midwestten.controller;

import edu.mum.cs.cs425.midten.midwestten.model.Athlete;
import edu.mum.cs.cs425.midten.midwestten.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class AthleteController {

    @Autowired
    private AthleteService athleteService;

    @GetMapping(value = { "/apm/athlete/list"})
    public ModelAndView displayAllAthletes(){
        ModelAndView modelAndView = new ModelAndView();
        //List<Account> accountList = accountService.getAllAccounts() ;
        //Double netLiq = athleteService.computeNetLiquidity();
        //modelAndView.addObject("netBal", netLiq);
        modelAndView.addObject("athleteList", athleteService.getAllAthleters());
        modelAndView.setViewName("athlete/list");
        return modelAndView;
    }

    @GetMapping(value = {"/athlete/new"})
    public String showNewAthleteForm(Model model){
        model.addAttribute("athlete", new Athlete());
//        model.addAttribute("customers", customerService.getAllCustomers());
//        model.addAttribute("accountTypes", accountTypeService.findAll());
        //model.addAttribute("new", LocalDate.now()); // baruun deed buland bairlah tsag
        return "athlete/new";

    }



    @PostMapping(value = {"/apm/athlete/new"})
    public String addNewAthlete(@Valid @ModelAttribute("athlete") Athlete athlete,
                                BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "athlete/new";
        }

        athlete = athleteService.saveAthlete(athlete);
        return "redirect:/apm/athlete/list";
    }


    @GetMapping(value = {"/apm/athlete/elite"})
    public ModelAndView getEliteAthlete(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("eliteAthleteList", athleteService.getEliteAthlete(10000));
        modelAndView.setViewName("athlete/elite");
        return modelAndView;
    }


}
