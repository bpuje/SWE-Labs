package edu.mum.cs.cs425.goldendomemarket.gdmarket.service;

import edu.mum.cs.cs425.goldendomemarket.gdmarket.model.Supplier;

import java.util.List;

public interface SupplierService {
    public abstract List<Supplier> getAllSupplier();
    public abstract Supplier saveSupplier(Supplier supplier);

}
