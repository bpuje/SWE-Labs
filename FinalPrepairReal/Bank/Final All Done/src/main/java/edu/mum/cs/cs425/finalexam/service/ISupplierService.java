package edu.mum.cs.cs425.finalexam.service;

import java.util.List;

import edu.mum.cs.cs425.finalexam.model.Supplier;

public interface ISupplierService {
	List<Supplier> findAll();
	Supplier save(Supplier supplier);
	Supplier findById(Long supplierId);
}
