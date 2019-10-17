package edu.mum.cs.cs425.finalexam.service;

import java.util.List;

import edu.mum.cs.cs425.finalexam.model.Customer;

public interface ICustomerService {
	List<Customer> findAll();
	Customer save(Customer customer);
}
