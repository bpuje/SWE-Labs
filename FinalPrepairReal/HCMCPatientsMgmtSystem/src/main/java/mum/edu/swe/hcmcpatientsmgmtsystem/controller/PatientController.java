package mum.edu.swe.hcmcpatientsmgmtsystem.controller;

import mum.edu.swe.hcmcpatientsmgmtsystem.domain.Patient;
import mum.edu.swe.hcmcpatientsmgmtsystem.domain.Status;
import mum.edu.swe.hcmcpatientsmgmtsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private Status status;

    @GetMapping(value={"/list"})
    public ModelAndView get(){
        List<Patient> patients = patientService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patients", patients);

        modelAndView.setViewName("patient/patient-list");
        return modelAndView;
    }

    @GetMapping(value={"/elist"})
    public ModelAndView getElderly(){
        List<Patient> patients = patientService.findByElderlyPatients(65);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patients", patients);
        modelAndView.setViewName("patient/patient-elist");
        return modelAndView;
    }

    @GetMapping(value={"/edit"})
    public String edit(Model model){
        model.addAttribute("patient", new Patient());
        model.addAttribute("outPatients", status.outPatient);
        return "patient/patient-edit";
    }

    @GetMapping(value={"/add"})
    public String add(Model model){
        model.addAttribute("patient", new Patient());
        model.addAttribute("outPatients", status.outPatient);
        return "patient/patient-edit";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable("id") Long id, Model model){
        model.addAttribute("patient", patientService.findById(id));
        model.addAttribute("outPatients", status.outPatient);
        return "patient/patient-edit";
    }

    @PostMapping(value={"/edit"})
    public String save(@Valid @ModelAttribute("patient") Patient patient, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("outPatients", status.outPatient);
            model.addAttribute("patient", patient);
            return "patient/patient-edit";
        }
        patientService.save(patient);
        return "redirect:/patient/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        patientService.delete(id);
        return "redirect:/patient/list";
    }

}
