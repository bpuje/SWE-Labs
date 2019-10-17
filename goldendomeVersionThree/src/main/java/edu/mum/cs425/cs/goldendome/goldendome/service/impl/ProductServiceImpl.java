package edu.mum.cs425.cs.goldendome.goldendome.service.impl;


import edu.mum.cs425.cs.goldendome.goldendome.model.Product;
import edu.mum.cs425.cs.goldendome.goldendome.repository.ProductRepository;
import edu.mum.cs425.cs.goldendome.goldendome.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

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
