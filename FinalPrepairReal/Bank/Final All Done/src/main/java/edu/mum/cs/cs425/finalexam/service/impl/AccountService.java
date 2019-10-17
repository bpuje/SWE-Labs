package edu.mum.cs.cs425.finalexam.service.impl;

import edu.mum.cs.cs425.finalexam.model.Account;
import edu.mum.cs.cs425.finalexam.model.Product;
import edu.mum.cs.cs425.finalexam.repository.IAccountRepository;
import edu.mum.cs.cs425.finalexam.repository.IProductRepository;
import edu.mum.cs.cs425.finalexam.service.IAccountService;
import edu.mum.cs.cs425.finalexam.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll(Sort.by("accountId"));
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

	@Override
	public Double computeNetLiquidity() {
		List<Account> accounts = accountRepository.findAll();
		double net = 0;
		
		for(Account acc : accounts) {
			if(acc.getAccountType().getAccountTypeName().toLowerCase().equals("loan"))
				net -= acc.getBalance();
			else
				net += acc.getBalance();
		}
		return net;
	}
}
