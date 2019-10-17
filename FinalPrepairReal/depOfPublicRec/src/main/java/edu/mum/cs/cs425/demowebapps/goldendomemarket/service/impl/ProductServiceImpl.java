package edu.mum.cs.cs425.demowebapps.goldendomemarket.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.demowebapps.goldendomemarket.model.Product;
import edu.mum.cs.cs425.demowebapps.goldendomemarket.repository.ProductRepository;
import edu.mum.cs.cs425.demowebapps.goldendomemarket.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository repo;

	@Override
	public Iterable<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by("productName"));
	}

	@Override
	public Product registerNewProduct(Product newProduct) {
		// TODO Auto-generated method stub
		return repo.save(newProduct);
		
	}

	@Override
	public Page<Product> getAllProductPaged(int page) {
		// TODO Auto-generated method stub
		return repo.findAll(PageRequest.of(page, 5, Sort.by("productName")));
	}

//	@Override
//	public Student findStudentByFirstName(String name) {
//		// TODO Auto-generated method stub
//		return repo.findStudentByFirstName(name);
//	}

	@Override
	public Product saveProduct(@Valid Product product) {
		// TODO Auto-generated method stub
		return repo.save(product);
	}

@Override
public Product getProductById(Integer productId) {
	// TODO Auto-generated method stub
	return repo.findById(productId).orElse(null);
}

@Override
public void deleteProductById(Integer productId) {
	repo.deleteById(productId);	
}





}
