package edu.mum.cs.cs425.midten.midwestten.service.impl;

import edu.mum.cs.cs425.midten.midwestten.model.Customer;
import edu.mum.cs.cs425.midten.midwestten.repository.CustomerRepository;
import edu.mum.cs.cs425.midten.midwestten.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;


    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll(Sort.by("lastName"));
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
