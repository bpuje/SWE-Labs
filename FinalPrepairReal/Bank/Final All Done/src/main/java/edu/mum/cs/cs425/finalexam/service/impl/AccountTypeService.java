package edu.mum.cs.cs425.finalexam.service.impl;

import edu.mum.cs.cs425.finalexam.model.AccountType;
import edu.mum.cs.cs425.finalexam.model.Product;
import edu.mum.cs.cs425.finalexam.repository.IAccountTypeRepository;
import edu.mum.cs.cs425.finalexam.repository.IProductRepository;
import edu.mum.cs.cs425.finalexam.service.IAccountService;
import edu.mum.cs.cs425.finalexam.service.IAccountTypeService;
import edu.mum.cs.cs425.finalexam.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeService implements IAccountTypeService {

    @Autowired
    private IAccountTypeRepository accountTypeRepository;

    @Override
    public List<AccountType> findAll() {
        return accountTypeRepository.findAll();
    }

    @Override
    public AccountType save(AccountType accountType) {
        return accountTypeRepository.save(accountType);
    }
}
