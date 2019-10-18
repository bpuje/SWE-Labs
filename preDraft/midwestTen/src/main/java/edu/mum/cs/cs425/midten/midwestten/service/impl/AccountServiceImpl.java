package edu.mum.cs.cs425.midten.midwestten.service.impl;

import edu.mum.cs.cs425.midten.midwestten.model.Account;
import edu.mum.cs.cs425.midten.midwestten.repository.AccountRepository;
import edu.mum.cs.cs425.midten.midwestten.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Double computeNetLiquidity() {
        double totalBalance = 0.0;
        List<Account> accountList = accountRepository.findAll();
        for (Account acct : accountList){
            if(acct.getAccountType().getAccountTypeName().toLowerCase().equals("loan")){
                totalBalance -= acct.getBalance();
            }else{
                totalBalance += acct.getBalance();
            }

        }
        return totalBalance;
    }
}
