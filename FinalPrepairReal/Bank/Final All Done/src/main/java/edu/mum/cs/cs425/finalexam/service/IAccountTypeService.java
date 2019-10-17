package edu.mum.cs.cs425.finalexam.service;

import java.util.List;

import edu.mum.cs.cs425.finalexam.model.AccountType;

public interface IAccountTypeService {
	List<AccountType> findAll();
	AccountType save(AccountType accountType);
}
