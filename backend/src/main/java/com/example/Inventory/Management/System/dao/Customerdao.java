package com.example.Inventory.Management.System.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Inventory.Management.System.model.Customer;

public interface Customerdao extends JpaRepository<Customer, Integer>{

}
