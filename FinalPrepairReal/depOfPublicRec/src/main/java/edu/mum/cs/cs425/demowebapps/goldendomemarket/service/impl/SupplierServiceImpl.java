package edu.mum.cs.cs425.demowebapps.goldendomemarket.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.demowebapps.goldendomemarket.model.Supplier;
import edu.mum.cs.cs425.demowebapps.goldendomemarket.repository.SupplierRepository;
import edu.mum.cs.cs425.demowebapps.goldendomemarket.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService{
	
	@Autowired
	private SupplierRepository repo;

	@Override
	public List<Supplier> getAllSupplier() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Supplier registerNewSupplier(Supplier newSupplier) {
		// TODO Auto-generated method stub
		return repo.save(newSupplier);
		
	}

	@Override
	public Page<Supplier> getAllSupplierPaged(int page) {
		// TODO Auto-generated method stub
		return repo.findAll(PageRequest.of(page, 5, Sort.by("name")));
	}

//	@Override
//	public Student findStudentByFirstName(String name) {
//		// TODO Auto-generated method stub
//		return repo.findStudentByFirstName(name);
//	}

	@Override
	public Supplier saveSupplier(@Valid Supplier supplier) {
		// TODO Auto-generated method stub
		return repo.save(supplier);
	}

@Override
public Supplier getSupplierById(Integer supplierId) {
	// TODO Auto-generated method stub
	return repo.findById(supplierId).orElse(null);
}

@Override
public void deleteSupplierById(Integer supplierId) {
	repo.deleteById(supplierId);	
}





}
