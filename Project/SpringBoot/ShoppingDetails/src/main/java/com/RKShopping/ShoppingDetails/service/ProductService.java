package com.RKShopping.ShoppingDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.RKShopping.ShoppingDetails.entity.Product;
import com.RKShopping.ShoppingDetails.repository.ProductRepository;


@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product){
		return repository.save(product);
	}
//	public List<Product> saveProducts(List<Product> products){
//		return repository.saveAll(products);
//	}
	
	public List<Product> getProducts(){
		return repository.findAll();
	}
	public Product getProductById(int id){
		return repository.findById(id).orElse(null);
	}

	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "Product Removed Successfully!  "+id;
	}
	public List<Product> getDetails(int pageNo, int pageSize )
	{
		
		
		
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Product> page = repository.findAll(pageable);
		
		List<Product> id = page.getContent();
		return id;

	}
	public Product updateProduct(Product product) {
		return repository.saveAndFlush(product);
	} 
}

