package edu.mum.cs.cs425.midten.midwestten.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
//@Table(name = "account")
public class Account {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

//    @Column(name = "account_number")
    private Long accountNumber;

//    @Column(precision=10, scale=2, name = "balance")
//    @NotNull
    private Double balance; // (Note: the account balance represents the amount of money in dollars and cents held in the account)

    @ManyToOne(optional = false)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private AccountType accountType;


    public Account() {
    }

    public Account(Long accountNumber,
                  /* @NotNull*/ Double balance, Customer customer, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
        this.accountType = accountType;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", customer=" + customer +
                ", accountType=" + accountType +
                '}';
    }
}
