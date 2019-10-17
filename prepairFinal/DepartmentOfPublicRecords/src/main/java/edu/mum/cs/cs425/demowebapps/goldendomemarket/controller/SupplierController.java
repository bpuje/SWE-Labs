package edu.mum.cs.cs425.demowebapps.goldendomemarket.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.demowebapps.goldendomemarket.model.Supplier;
import edu.mum.cs.cs425.demowebapps.goldendomemarket.service.SupplierService;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping(value = {"/supplier/register"})
	public String showNewStudentRegisterForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "supplier/register";
	}
	@PostMapping(value = {"/supplier/register"})
	public String registerNewStudent(@Valid @ModelAttribute("supplier") Supplier supplier,
	                                     BindingResult bindingResult, Model model) {
	        if (bindingResult.hasErrors()) {
	            model.addAttribute("errors", bindingResult.getAllErrors());
	            return "supplier/register";
	        }
	        supplier = supplierService.registerNewSupplier(supplier);
	        return "redirect:/supplier/list";
	    }
	
	@GetMapping(value = {"/supplier/list"})
	public ModelAndView showStudentsListForm(@RequestParam(defaultValue = "0")int pageNo) {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.addObject("suppliers", supplierService.getAllSupplierPaged(pageNo));
	        modelAndView.addObject("currentPageNo", pageNo); //current page no
	        modelAndView.setViewName("supplier/list");
	        return modelAndView;
	}
	

	
	
}
