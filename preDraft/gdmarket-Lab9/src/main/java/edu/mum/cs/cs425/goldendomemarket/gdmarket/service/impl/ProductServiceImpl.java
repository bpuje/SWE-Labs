package edu.mum.cs.cs425.goldendomemarket.gdmarket.service.impl;

import edu.mum.cs.cs425.goldendomemarket.gdmarket.model.Product;
import edu.mum.cs.cs425.goldendomemarket.gdmarket.repository.ProductRepository;
import edu.mum.cs.cs425.goldendomemarket.gdmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
