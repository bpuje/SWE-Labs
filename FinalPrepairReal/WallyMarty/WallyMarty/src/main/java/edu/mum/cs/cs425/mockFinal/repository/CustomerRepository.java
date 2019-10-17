package edu.mum.cs.cs425.mockFinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.mockFinal.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("FROM Customer C WHERE C.dateOfBirth <= '1979-05-18'")
	List<Customer> findAllPrimeCustomer();
	 
}