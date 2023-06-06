package com.example.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.models.Product;
import com.example.project.services.ProductService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired ProductService productService;
	
	
	@GetMapping
	public List<Product> getProductAll() {
		List<Product> products = productService.findAll();
		return products;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductByID(@PathVariable Long id) {
		//return productService.findByID(id);
		try {
			return new ResponseEntity<Product>(productService.findByID(id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return  new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product p) {
		Product product = productService.create(p);
		return product;
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@RequestBody Product p, @PathVariable Long id) {
		Product product = productService.update(p);
		return product;
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.delete(id);
		return "Product deleted!";
	}

}
