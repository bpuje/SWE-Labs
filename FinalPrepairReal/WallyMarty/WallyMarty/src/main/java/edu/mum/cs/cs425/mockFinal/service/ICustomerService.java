package edu.mum.cs.cs425.mockFinal.service;

import java.util.List;

import javax.validation.Valid;

import edu.mum.cs.cs425.mockFinal.model.Customer;

public interface ICustomerService {

	public List<Customer> findAll();

	public Customer save(Customer customer);

	public List<Customer> findPrimeCustomers();

}
