package edu.mum.cs.cs425.finalexam.patient.patient.controller;

import edu.mum.cs.cs425.finalexam.patient.patient.model.Patient;
import edu.mum.cs.cs425.finalexam.patient.patient.service.PatientService;
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
@RequestMapping(value = {"/patient"})
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(value = {"/list"})
    public ModelAndView displayAllPatient(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patientList", patientService.getAllPatient());
        modelAndView.setViewName("patient/list");

        return modelAndView;
    }

    @GetMapping(value = {"/register"})
    public String registerNewPatient(Model model){
        model.addAttribute("patient", new Patient());
        //model.addAttribute("patientList", patientService.getAllPatient());
        return "patient/register";
    }
    @PostMapping(value = {"/register"})
    public String registerNewPatient(@Valid @ModelAttribute("patient") Patient patient,
                                     BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "patient/register";
        }
        model.addAttribute("patientList", patientService.getAllPatient());
        patient = patientService.savePatient(patient);
        return "redirect:/patient/list";
    }

    @GetMapping(value = {"/elder"})
    public String getElderPatient(Model model){
        //ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("elderPatientLists", patientService.getElderlyPatients(60));
        return "patient/elder";
    }
}
