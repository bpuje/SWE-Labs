package edu.mum.cs.cs425.finalexam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.cs425.finalexam.model.AccountType;
import edu.mum.cs.cs425.finalexam.model.Customer;
import edu.mum.cs.cs425.finalexam.model.Supplier;

public interface IAccountTypeRepository extends JpaRepository<AccountType, Long> {
	
}
