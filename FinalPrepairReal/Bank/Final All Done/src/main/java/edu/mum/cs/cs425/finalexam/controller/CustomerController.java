package edu.mum.cs.cs425.finalexam.controller;

import edu.mum.cs.cs425.finalexam.model.Product;
import edu.mum.cs.cs425.finalexam.model.AccountType;
import edu.mum.cs.cs425.finalexam.model.Customer;
import edu.mum.cs.cs425.finalexam.service.IProductService;
import edu.mum.cs.cs425.finalexam.service.IAccountTypeService;
import edu.mum.cs.cs425.finalexam.service.ICustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    
    @Autowired
    private IAccountTypeService accountTypeService;
    
    @Autowired
    private void init() {
    	List<AccountType> accTypes = accountTypeService.findAll();
    	if(accTypes == null || accTypes.size() == 0) {
    		AccountType at1 = new AccountType();
    		at1.setAccountTypeName("Checking");

    		AccountType at2 = new AccountType();
    		at1.setAccountTypeName("Loan");

    		AccountType at3 = new AccountType();
    		at1.setAccountTypeName("Saving");
    		
    		accountTypeService.save(at1);
    		accountTypeService.save(at2);
    		accountTypeService.save(at2);
    	}
    }

    @GetMapping(value = {"/list", "/", ""})
    public String showCustomers(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers/list";
    }

    @GetMapping(value = "/add")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/new";
    }

    @PostMapping(value = "/add")
    public String addNewCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "Customers/new";
        }
        customerService.save(customer);
        return "redirect:/customers";
    }
}

