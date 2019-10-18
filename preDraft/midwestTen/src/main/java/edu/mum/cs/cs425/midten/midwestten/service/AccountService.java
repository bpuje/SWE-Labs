package edu.mum.cs.cs425.midten.midwestten.service;

import edu.mum.cs.cs425.midten.midwestten.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {
    public abstract List<Account> getAllAccounts();
    public abstract Account saveAccount(Account account);
    public abstract Double computeNetLiquidity();
}
