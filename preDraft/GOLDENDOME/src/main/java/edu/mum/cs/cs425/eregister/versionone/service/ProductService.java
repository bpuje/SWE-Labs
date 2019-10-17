package edu.mum.cs.cs425.eregister.versionone.service;

import edu.mum.cs.cs425.eregister.versionone.model.Product;

import java.util.List;

public interface ProductService {

    public abstract List<Product> getAllProducts();
    public abstract Product saveProduct(Product product);
    public abstract Product getStudentById(Long productId);
}
