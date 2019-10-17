package edu.mum.cs.cs425.goldendomemarket.gdmarket.service;

import edu.mum.cs.cs425.goldendomemarket.gdmarket.model.Product;

import java.util.List;

public interface ProductService {
    public abstract List<Product> getAllProduct();
    public abstract Product saveProduct(Product product);
}
