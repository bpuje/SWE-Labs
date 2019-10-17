package edu.mum.cs.cs425.finalexam.service;

import edu.mum.cs.cs425.finalexam.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();
    Product save(Product product);

}
