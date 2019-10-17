package edu.mum.cs.cs425.eregister.versionone.service;

import edu.mum.cs.cs425.eregister.versionone.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.Valid;
import java.util.List;


public interface SupplierService {
    public abstract List<Supplier> getAllSuppliers();
    public abstract Supplier saveSupplier(@Valid Supplier supplier);



//
//    public abstract Supplier getSupplierById(Integer supplierId);
//    public abstract Supplier saveSupplier(@Valid Supplier supplier);
//    public abstract void deleteSupplierById(Integer supplierId);
}
