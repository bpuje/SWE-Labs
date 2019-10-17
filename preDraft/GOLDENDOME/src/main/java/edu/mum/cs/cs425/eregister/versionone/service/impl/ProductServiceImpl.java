package edu.mum.cs.cs425.eregister.versionone.service.impl;

import edu.mum.cs.cs425.eregister.versionone.model.Product;
import edu.mum.cs.cs425.eregister.versionone.repository.ProductRepository;
import edu.mum.cs.cs425.eregister.versionone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getStudentById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }
}
