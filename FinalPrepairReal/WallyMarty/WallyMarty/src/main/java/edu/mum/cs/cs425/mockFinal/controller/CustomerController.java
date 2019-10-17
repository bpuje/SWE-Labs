package edu.mum.cs.cs425.mockFinal.controller;

import edu.mum.cs.cs425.mockFinal.model.Customer;
import edu.mum.cs.cs425.mockFinal.service.ICustomerService;

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
@RequestMapping("/customer") //ene bol browser deer duudagdah zam shuu!
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping(value = {"/list", "/", ""})
    public String showCustomers(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers); // ehnii customers gedeg String n list.html.n 29 murnii ${customers}".n customers.tei match hiih yostoi
        return "customer-view/list"; // ene murund bgaa customers gedeg n resources dotor baih templates folder dotorh
        						// customers folder.toi match hiih yostoi. 
        						// deerh return.n ard bgaa list n customers folder dotorh list.html-tei taarah yostoi.
    }

    @GetMapping(value = "/add")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new Customer()); // customer gedeg n UI dotor bgaa form deerh th:object="${customer}"
        												// gedeg attribute.n customer.tei adil baih yostoi.
        return "customer-view/new"; // 33 murnii tailbartai adilhan
    }

    @PostMapping(value = "/add")
    public String addNewCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "customer-view/new";
        }
        customerService.save(customer);
        return "redirect:/customer"; //RequestMapping.n ard taliin customer.tei adilhan baih yostoi
    }
    
    @GetMapping("/prime")
    public String showPrimeCustomer(Model model) {
    	List<Customer> primeCustomers = customerService.findPrimeCustomers();
    	model.addAttribute("primeCustomers", primeCustomers);
    	return "customer-view/prime-list";
    }
}

