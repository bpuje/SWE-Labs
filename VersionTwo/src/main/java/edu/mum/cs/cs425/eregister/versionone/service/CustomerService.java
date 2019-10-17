package edu.mum.cs.cs425.eregister.versionone.service;

import edu.mum.cs.cs425.eregister.versionone.model.Customer;

import java.util.List;

public interface CustomerService {
    public abstract List<Customer> getAllCustomers();
    public abstract Customer saveCustomer(Customer customer);
    public abstract Customer getCustomerById(Long customerId);
    public abstract void deleteCustomerById(Long customerId);
    //public abstract List<Customer> searchCustomers(String searchString);
    public abstract String printPrimeCustomersByAge(Customer customer);
}
