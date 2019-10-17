package edu.mum.cs.cs425.finalexam.service.impl;

import edu.mum.cs.cs425.finalexam.model.Product;
import edu.mum.cs.cs425.finalexam.repository.IProductRepository;
import edu.mum.cs.cs425.finalexam.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll(Sort.by("productNumber"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
