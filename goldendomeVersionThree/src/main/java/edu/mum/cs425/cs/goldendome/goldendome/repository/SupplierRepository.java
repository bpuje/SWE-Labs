package edu.mum.cs425.cs.goldendome.goldendome.repository;

import edu.mum.cs425.cs.goldendome.goldendome.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
//	Optional<Supplier> findSupplierByFirstName(String firstName); // yostoi sonin yumdaa!! Eniig end bichlee.
//						
//	Optional<Supplier> findSupplierByLastName(String lastName);   // Itellij IDE deer garaad baihiin Eclpise deer alga
	
	Optional<Supplier> findSupplierBySupplierId(Integer supplierId);
	
	

}
