package edu.mum.cs.cs425.demowebapps.goldendomemarket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.demowebapps.goldendomemarket.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
//	Optional<Supplier> findSupplierByFirstName(String firstName); // yostoi sonin yumdaa!! Eniig end bichlee.
//						
//	Optional<Supplier> findSupplierByLastName(String lastName);   // Itellij IDE deer garaad baihiin Eclpise deer alga
	
	Optional<Supplier> findSupplierBySupplierId(Integer supplierId);
	
	

}
