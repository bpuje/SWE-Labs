package edu.mum.cs.cs425.goldendomemarket.gdmarket.controller;

import edu.mum.cs.cs425.goldendomemarket.gdmarket.model.Supplier;
import edu.mum.cs.cs425.goldendomemarket.gdmarket.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping(value = {"/supplier/list"})
    public ModelAndView showListSupply(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("suppliers", supplierService.getAllSupplier());
        modelAndView.setViewName("supplier/list");
        return modelAndView;
    }

    @PostMapping(value = {"/supplier/new"})
    public String addNewSupplier(@Valid @ModelAttribute("supplier") Supplier supplier,
                                 BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "supplier/new";
        }

        supplier = supplierService.saveSupplier(supplier);
        return "redirect:/supplier/list";

    }

    @GetMapping(value = {"/supplier/new"})
    public String showNewSupplierForm(Model model){
        model.addAttribute("supplier", new Supplier());
        return "supplier/new";
    }

}
