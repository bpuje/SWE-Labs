package edu.mum.cs.cs425.midten.midwestten.service.impl;

import edu.mum.cs.cs425.midten.midwestten.model.AccountType;
import edu.mum.cs.cs425.midten.midwestten.repository.AccountTypeRepository;
import edu.mum.cs.cs425.midten.midwestten.service.AccountTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeServiceImpl implements AccountTypeService {
    private AccountTypeRepository accountTypeRepository;

    public AccountTypeServiceImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }


    @Override
    public List<AccountType> findAll() {
        return accountTypeRepository.findAll();
    }

    @Override
    public AccountType saveType(AccountType accountType) {
        return accountTypeRepository.save(accountType);
    }
}
