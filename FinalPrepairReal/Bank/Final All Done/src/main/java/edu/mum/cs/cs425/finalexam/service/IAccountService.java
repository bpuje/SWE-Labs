package edu.mum.cs.cs425.finalexam.service;

import edu.mum.cs.cs425.finalexam.model.Account;
import edu.mum.cs.cs425.finalexam.model.Product;

import java.util.List;

public interface IAccountService {

    List<Account> findAll();
    Account save(Account account);
	Double computeNetLiquidity();

}
