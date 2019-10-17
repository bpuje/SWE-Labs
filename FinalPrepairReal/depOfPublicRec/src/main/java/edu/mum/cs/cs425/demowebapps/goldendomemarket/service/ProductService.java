package edu.mum.cs.cs425.demowebapps.goldendomemarket.service;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import edu.mum.cs.cs425.demowebapps.goldendomemarket.model.Product;

public interface ProductService {
	
	public abstract Iterable<Product> getAllProduct();
	public abstract Page<Product> getAllProductPaged(int page);
	public abstract Product registerNewProduct(Product newProduct);
	
	public abstract Product getProductById(Integer productId);	
	public abstract Product saveProduct(@Valid Product product);
	public abstract void deleteProductById(Integer productId);
	

}
