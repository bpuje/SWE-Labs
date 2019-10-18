package edu.mum.cs.cs425.midten.midwestten.service;

import edu.mum.cs.cs425.midten.midwestten.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    public abstract List<Customer> getAllCustomers();
    public abstract Customer saveCustomer(Customer customer);

}
