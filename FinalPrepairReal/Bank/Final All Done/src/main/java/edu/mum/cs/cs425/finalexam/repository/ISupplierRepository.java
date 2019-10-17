package edu.mum.cs.cs425.finalexam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.cs425.finalexam.model.Supplier;

public interface ISupplierRepository extends JpaRepository<Supplier, Long> {
	
}
