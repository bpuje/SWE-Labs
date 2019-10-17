package edu.mum.cs.cs425.goldendomemarket.gdmarket.service.impl;

import edu.mum.cs.cs425.goldendomemarket.gdmarket.model.Supplier;
import edu.mum.cs.cs425.goldendomemarket.gdmarket.repository.SupplierRepository;
import edu.mum.cs.cs425.goldendomemarket.gdmarket.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupplierServiceImpl implements SupplierService {


    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> getAllSupplier() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
}
