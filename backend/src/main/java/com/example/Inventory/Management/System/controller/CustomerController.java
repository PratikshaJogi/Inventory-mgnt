package com.example.Inventory.Management.System.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Inventory.Management.System.dao.Customerdao;
import com.example.Inventory.Management.System.exception.ResourceNotFoundException;
import com.example.Inventory.Management.System.model.Customer;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inventoryMgt/")//http://localhost:8080/inventoryMgt/customers
public class CustomerController {
	@Autowired
  private Customerdao customerdao;
  
  //get all customers
	
	@GetMapping("/customers")
	public List<Customer> getallCustumors() {
		return customerdao.findAll();
	}
  
	//create customer Rest API
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerdao.save(customer);
	}
	// get customer by id Rest API
		@GetMapping("/customers/{id}")
		public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
			Customer customer = customerdao.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + id));
			return ResponseEntity.ok(customer);
		}
		
		// update customer Rest API
		
		@PutMapping("/customers/{id}")
		public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customerDetails){
			Customer customer = customerdao.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + id));
			
			customer.setFirstName(customerDetails.getFirstName());
			customer.setLastName(customerDetails.getLastName());
			customer.setEmailId(customerDetails.getEmailId());
			customer.setTotalAmmount(customerDetails.getTotalAmmount());
			
			Customer updatedCustomer = customerdao.save(customer);
			return ResponseEntity.ok(updatedCustomer);
		}
		//delete customer Rest API
		@DeleteMapping("/customers/{id}")
		public ResponseEntity<Map<String, Boolean>>deleteCustomer(@PathVariable int id){
			Customer customer = customerdao.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + id));
			customerdao.delete(customer);
			Map<String,Boolean>response = new HashMap<>();
			response.put("deleted",Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
//		@CrossOrigin(origins = "http://localhost:4200/inventoryMgt/loginUser")
//		@GetMapping("/loginUser")
//		public ResponseEntity<String> login(@RequestBody Login l){
//			Customer c = customerdao.findById(l.getCustomerid()).orElse(null);
//			if(e==null || !e.getCustomerPass().equals(l.getEmpPass())) {
//				new ResourceNotFoundException(l.getCustomerid()+" not available");
//			}
//			return ResponseEntity.ok("Success");
//		}
}


	