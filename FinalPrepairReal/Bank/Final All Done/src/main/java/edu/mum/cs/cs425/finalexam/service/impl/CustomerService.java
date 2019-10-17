package edu.mum.cs.cs425.finalexam.service.impl;

import edu.mum.cs.cs425.finalexam.model.Customer;
import edu.mum.cs.cs425.finalexam.model.Supplier;
import edu.mum.cs.cs425.finalexam.repository.ICustomerRepository;
import edu.mum.cs.cs425.finalexam.repository.IProductRepository;
import edu.mum.cs.cs425.finalexam.repository.ISupplierRepository;
import edu.mum.cs.cs425.finalexam.service.ICustomerService;
import edu.mum.cs.cs425.finalexam.service.IProductService;
import edu.mum.cs.cs425.finalexam.service.ISupplierService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll(Sort.by("lastName"));
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
