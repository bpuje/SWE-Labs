package edu.mum.cs.cs425.demowebapps.goldendomemarket.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import edu.mum.cs.cs425.demowebapps.goldendomemarket.model.Supplier;


public interface SupplierService {
	public abstract List<Supplier> getAllSupplier();
	public abstract Page<Supplier> getAllSupplierPaged(int page);
	public abstract Supplier registerNewSupplier(Supplier newSupplier);
	
	public abstract Supplier getSupplierById(Integer supplierId);	
	public abstract Supplier saveSupplier(@Valid Supplier supplier);
	public abstract void deleteSupplierById(Integer supplierId);
	
}
