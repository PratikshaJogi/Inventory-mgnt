package com.example.Inventory.Management.System.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventory.Management.System.model.Product;

public interface Productdao extends JpaRepository<Product,Integer>{

}
