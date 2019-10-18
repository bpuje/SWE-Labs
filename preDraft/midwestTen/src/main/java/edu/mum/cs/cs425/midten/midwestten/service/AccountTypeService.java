package edu.mum.cs.cs425.midten.midwestten.service;

import edu.mum.cs.cs425.midten.midwestten.model.AccountType;

import java.util.List;

public interface AccountTypeService {
    public abstract List<AccountType> findAll();
    public abstract AccountType saveType(AccountType accountType);
}
