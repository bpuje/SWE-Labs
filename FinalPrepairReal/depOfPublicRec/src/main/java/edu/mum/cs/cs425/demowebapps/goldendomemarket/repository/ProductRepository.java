package edu.mum.cs.cs425.demowebapps.goldendomemarket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.demowebapps.goldendomemarket.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	Optional<Product> findProductByProductName(String productName); // yostoi sonin yumdaa!! Eniig end bichlee.
						
	//Optional<Product> findProductByLastName(String lastName);   // Itellij IDE deer garaad baihiin Eclpise deer alga
	
	Optional<Product> findProductByProductId(Integer productId);
	
	

}
