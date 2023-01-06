package com.example.Inventory.Management.System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Inventory.Management.System.model.Product;
import com.example.Inventory.Management.System.service.ProductService;

@RestController
@RequestMapping("/inventoryMgt/")//http://localhost:8080/inventoryMgt/products
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	@Autowired
	private ProductService ps;
	
	@GetMapping("/products")
	public List<Product> getProduct() {
		return ps.viewProducts();
	}
	
	@GetMapping("/products/{pid}")
	public Product getProduct(@PathVariable int pid) {
		return ps.viewProduct(pid);
	}
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product p) {
		return ps.addProduct(p);
	}
	
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product p) {
		return ps.updateProduct(p);
	}
	
	@DeleteMapping("/products/{pid}")
	public String deleteProduct(@PathVariable int pid) {
		return ps.deleteProduct(pid);
	}

}
