package edu.mum.cs.cs425.eregister.versionone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.cs.cs425.eregister.versionone.model.Customer;
import edu.mum.cs.cs425.eregister.versionone.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class MyCustomerMgmtApp {


    @Autowired
    private CustomerService customerService;

    @GetMapping(value = {"/srm/customer/list"})
    public ModelAndView listCustomers(){
        ModelAndView modelAndView = new ModelAndView();
        List<Customer> customers = customerService.getAllCustomers();
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("searchString", "");
        modelAndView.addObject("customersCount", customers.size());
        modelAndView.setViewName("customer/list");
        return modelAndView;
    }

    @GetMapping(value = {"/srm/customer/new"})
    public String displayNewCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/new";
    }

    @PostMapping(value = {"/srm/customer/new"})
    public String addNewCustomer(@Valid @ModelAttribute("customer") Customer customer,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "customer/new";
        }
        customer = customerService.saveCustomer(customer);

        String pringJSON = customerService.printPrimeCustomersByAge(customer);

        System.out.println("Printing JSON: " + pringJSON);

        System.out.println("End hewlej uzew =====" + customer);
        return "redirect:/srm/customer/list";
    }

    @GetMapping(value = {"/srm/customer/edit/{customerId}"})
    public String editCustomerForm(@PathVariable Long customerId, Model model){
        Customer customer = customerService.getCustomerById(customerId);
        if(customer != null){
            model.addAttribute("customer", customer);
            return "customer/edit";
        }
//        System.out.println("editStudent ====" + student.getFirstName());
        return "customer/list";
    }


    public String printPrimeCustomers(Customer cust){

        // Creating Object of ObjectMapper define in Jakson Api
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = "";
        System.out.println(cust.getName());
        try {
            // get Oraganisation object as a json string
             jsonStr = Obj.writeValueAsString(cust);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
