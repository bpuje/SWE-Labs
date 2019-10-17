package edu.mum.cs425.cs.goldendome.goldendome.service.impl;

import edu.mum.cs425.cs.goldendome.goldendome.model.Supplier;
import edu.mum.cs425.cs.goldendome.goldendome.repository.SupplierRepository;
import edu.mum.cs425.cs.goldendome.goldendome.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService{
	
	@Autowired
	private SupplierRepository repo;

	@Override
	public List<Supplier> getAllSupplier() {
		return repo.findAll();
	}

	@Override
	public Supplier registerNewSupplier(Supplier newSupplier) {
		return repo.save(newSupplier);
		
	}

	@Override
	public Page<Supplier> getAllSupplierPaged(int page) {
		return repo.findAll(PageRequest.of(page, 5, Sort.by("name")));
	}

//	@Override
//	public Student findStudentByFirstName(String name) {
//		return repo.findStudentByFirstName(name);
//	}

	@Override
	public Supplier saveSupplier(@Valid Supplier supplier) {
		return repo.save(supplier);
	}

@Override
public Supplier getSupplierById(Integer supplierId) {
	return repo.findById(supplierId).orElse(null);
}

@Override
public void deleteSupplierById(Integer supplierId) {
	repo.deleteById(supplierId);	
}





}
