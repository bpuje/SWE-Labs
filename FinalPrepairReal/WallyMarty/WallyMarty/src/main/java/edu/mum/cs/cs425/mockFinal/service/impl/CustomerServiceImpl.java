package edu.mum.cs.cs425.mockFinal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.mockFinal.model.Customer;
import edu.mum.cs.cs425.mockFinal.repository.CustomerRepository;
import edu.mum.cs.cs425.mockFinal.service.ICustomerService;



@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> findPrimeCustomers() {
		
		return customerRepository.findAllPrimeCustomer();
	}

}
