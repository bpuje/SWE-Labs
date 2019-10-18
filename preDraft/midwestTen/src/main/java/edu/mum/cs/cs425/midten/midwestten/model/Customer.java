package edu.mum.cs.cs425.midten.midwestten.model;

import javax.persistence.Entity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
//@Table(name = "Customer")
public class Customer {


    @Id
    @GeneratedValue
    private Long customerId;

//    @Column(name = "costomer_number")
    private Long customerNumber;

//    @Column(name = "first_name")
//    @NotBlank(message = "First Name should be entered")
    private String firstName;


    private String middleName;

//    @Column(name = "customer_last_name")
//    @NotBlank(message = "Last Name should be entered")
    private String lastName;

//    @Column
//    @NotBlank(message = "Email shoud be entered")
    private String emailAddress;

//    @Column(name = "contact_phone_number")
    private String contactPhoneNumber;

//    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    public Customer() {
    }



//
//    @ManyToOne()
//    @JoinColumn(name = "account_id")
//    private List<Account> accountList;


    public Customer(Long customerNumber,
                   /* @NotBlank(message = "First Name should be entered") */String firstName, String middleName,
                    /*@NotBlank(message = "Last Name should be entered")*/ String lastName,
                    /*@NotBlank(message = "Email shoud be entered")*/ String emailAddress, String contactPhoneNumber, LocalDate dateOfBirth/*, List<Account> accountList*/) {
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.contactPhoneNumber = contactPhoneNumber;
        this.dateOfBirth = dateOfBirth;
        //this.accountList = accountList;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

//    public List<Account> getAccountList() {
//        return accountList;
//    }
//
//    public void setAccountList(List<Account> accountList) {
//        this.accountList = accountList;
//    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerNumber=" + customerNumber +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", contactPhoneNumber='" + contactPhoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                //", accountList=" + accountList +
                '}';
    }
}
