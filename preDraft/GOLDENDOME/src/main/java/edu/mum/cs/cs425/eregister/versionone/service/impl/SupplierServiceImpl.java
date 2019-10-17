package edu.mum.cs.cs425.eregister.versionone.service.impl;

import edu.mum.cs.cs425.eregister.versionone.model.Supplier;
import edu.mum.cs.cs425.eregister.versionone.repository.SupplierRepository;
import edu.mum.cs.cs425.eregister.versionone.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;



@Service
public class SupplierServiceImpl implements SupplierService {


    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier saveSupplier(@Valid Supplier supplier) {
        return supplierRepository.save(supplier);
    }
}
