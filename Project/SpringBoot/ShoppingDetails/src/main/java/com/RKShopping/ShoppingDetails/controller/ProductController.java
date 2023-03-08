package com.RKShopping.ShoppingDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RKShopping.ShoppingDetails.entity.Product;
import com.RKShopping.ShoppingDetails.service.ProductService;



@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
//	@PostMapping("/addProducts")
//	public List<Product> addProducts(@RequestBody List<Product> products) {
//		return service.saveProducts(products);
//	}
	
	
	@GetMapping("/products")
	public List<Product> findAllProducts(){
		return service.getProducts();
	}
	
	@GetMapping("/productById/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
	}
	 
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	

	@GetMapping("/findall/{pageNo}/{pageSize}")
	public List<Product> listing(@PathVariable("pageNo")int pageNo,@PathVariable("pageSize")int pageSize) {
		 return  service.getDetails(pageNo, pageSize);
	 }
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
		
	}
}
