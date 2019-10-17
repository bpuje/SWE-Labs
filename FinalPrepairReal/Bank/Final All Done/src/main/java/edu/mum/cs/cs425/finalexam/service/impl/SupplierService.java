package edu.mum.cs.cs425.finalexam.service.impl;

import edu.mum.cs.cs425.finalexam.model.Supplier;
import edu.mum.cs.cs425.finalexam.repository.IProductRepository;
import edu.mum.cs.cs425.finalexam.repository.ISupplierRepository;
import edu.mum.cs.cs425.finalexam.service.IProductService;
import edu.mum.cs.cs425.finalexam.service.ISupplierService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SupplierService implements ISupplierService {

    @Autowired
    private ISupplierRepository supplierRepository;

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll(Sort.by("supplierNumber"));
    }

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier findById(Long supplierId) {
        return supplierRepository.findById(supplierId).orElse(null);
    }
}
