package edu.mum.cs425.cs.goldendome.goldendome.service;


import edu.mum.cs425.cs.goldendome.goldendome.model.Product;
import org.springframework.data.domain.Page;

import javax.validation.Valid;
import java.util.List;

public interface ProductService {

    public abstract Iterable<Product> getAllProduct();
    public abstract Page<Product> getAllProductPaged(int page);
    public abstract Product registerNewProduct(Product newProduct);

    public abstract Product getProductById(Integer productId);
    public abstract Product saveProduct(@Valid Product product);
    public abstract void deleteProductById(Integer productId);
}
