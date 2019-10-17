package edu.mum.cs425.cs.goldendome.goldendome.service;

import edu.mum.cs425.cs.goldendome.goldendome.model.Supplier;
import org.springframework.data.domain.Page;

import javax.validation.Valid;
import java.util.List;

public interface SupplierService {
    public abstract List<Supplier> getAllSupplier();
    public abstract Page<Supplier> getAllSupplierPaged(int page);
    public abstract Supplier registerNewSupplier(Supplier newSupplier);

    public abstract Supplier getSupplierById(Integer supplierId);
    public abstract Supplier saveSupplier(@Valid Supplier supplier);
    public abstract void deleteSupplierById(Integer supplierId);
}
