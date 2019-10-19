package edu.mum.cs.cs425.midten.midwestten.controller;

import edu.mum.cs.cs425.midten.midwestten.model.Customer;
import edu.mum.cs.cs425.midten.midwestten.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = {"/midwest/customer/list"})
    public ModelAndView displayAllCustomer(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customers", customerService.getAllCustomers());
        modelAndView.setViewName("customer/list");
        //System.out.println("================"+customerService.getAllCustomers());
        return modelAndView;
    }

    @GetMapping(value = {"/customer/new"})
    public String showNewCustomerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/new";

    }

    @PostMapping(value = {"/midwest/customer/new"})
    public String addNewCustomer(@Valid @ModelAttribute("customer") Customer customer,
                                 BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "customer/new";
        }

        customer = customerService.saveCustomer(customer);
        return "redirect:/midwest/customer/list";

    }
}
