package edu.mum.cs.cs425.finalexam.controller;

import edu.mum.cs.cs425.finalexam.model.Account;
import edu.mum.cs.cs425.finalexam.model.AccountType;
import edu.mum.cs.cs425.finalexam.service.IAccountService;
import edu.mum.cs.cs425.finalexam.service.IAccountTypeService;
import edu.mum.cs.cs425.finalexam.service.ICustomerService;
import edu.mum.cs.cs425.finalexam.service.ISupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

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
    public String showaccounts(Model model) {
        List<Account> accounts = accountService.findAll();
        Double netLiq = accountService.computeNetLiquidity();
        model.addAttribute("accounts", accounts);
        model.addAttribute("net", netLiq);
        return "accounts/list";
    }

    @GetMapping(value = "/add")
    public String showAddAccountForm(Model model) {
        model.addAttribute("account", new Account());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("accountTypes", accountTypeService.findAll());
        return "accounts/new";
    }

    @PostMapping(value = "/add")
    public String addNewaccount(@Valid @ModelAttribute("account") Account account, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "accounts/new";
        }
        accountService.save(account);
        return "redirect:/accounts";
    }
}

