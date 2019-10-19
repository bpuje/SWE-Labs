package edu.mum.cs.cs425.midten.midwestten.controller;

import edu.mum.cs.cs425.midten.midwestten.model.Account;
import edu.mum.cs.cs425.midten.midwestten.model.AccountType;
import edu.mum.cs.cs425.midten.midwestten.model.Customer;
import edu.mum.cs.cs425.midten.midwestten.service.AccountService;
import edu.mum.cs.cs425.midten.midwestten.service.AccountTypeService;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountTypeService accountTypeService;

    @Autowired
    private void init(){
        List<AccountType> accountTypes = accountTypeService.findAll();
        if(accountTypes == null || accountTypes.size() == 0){
            AccountType at1 = new AccountType();
            at1.setAccountTypeName("Checking");

            AccountType at2 = new AccountType();
            at2.setAccountTypeName("Savings");

            AccountType at3 = new AccountType();
            at3.setAccountTypeName("Loan");

            accountTypeService.saveType(at1);
            accountTypeService.saveType(at2);
            accountTypeService.saveType(at3);
        }
    }

    @GetMapping(value = { "/midwest/account/list"})
    public ModelAndView displayAllAccounts(){
        ModelAndView modelAndView = new ModelAndView();
        //List<Account> accountList = accountService.getAllAccounts() ;
        Double netLiq = accountService.computeNetLiquidity();
        modelAndView.addObject("accounts", accountService.getAllAccounts());
        modelAndView.addObject("netBal", netLiq);
        modelAndView.setViewName("account/list");

        return modelAndView;
    }

    @GetMapping(value = {"/account/new"})
    public String showNewAccountForm(Model model){
        model.addAttribute("account", new Account());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("accountTypes", accountTypeService.findAll());
        model.addAttribute("new", LocalDate.now()); // baruun deed buland bairlah tsag
        return "account/new";

    }

    @PostMapping(value = {"/midwest/account/new"})
    public String addNewAccount(@Valid @ModelAttribute("account") Account account,
                                 BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "account/new";
        }

        account = accountService.saveAccount(account);
        return "redirect:/midwest/account/list";

    }
}
