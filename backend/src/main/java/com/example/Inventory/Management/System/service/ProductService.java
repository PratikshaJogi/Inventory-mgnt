package com.example.Inventory.Management.System.service;

import java.util.List;

import com.example.Inventory.Management.System.model.Product;

public interface ProductService {

	Product addProduct(Product p);
	Product viewProduct(int pid);
	List<Product> viewProducts();
	String deleteProduct(int pid);
	Product updateProduct(Product p);
}
