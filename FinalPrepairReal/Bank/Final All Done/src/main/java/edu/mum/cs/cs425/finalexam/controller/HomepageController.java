package edu.mum.cs.cs425.finalexam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.cs425.finalexam.model.AccountType;
import edu.mum.cs.cs425.finalexam.service.IAccountTypeService;

@Controller
public class HomepageController {

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

	@GetMapping(value={"/", "home"})
	public String homepage() {
		return "homepage/index";
	}
	
}