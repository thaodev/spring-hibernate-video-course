package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
		
	//autowire the CustomerService
	@Autowired
	private CustomerService customerService;
	
	
	//add mapping for GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomerList(){
		
		return customerService.getCustomers();
	}
	
	//add mapping for GET/customers/{customerId}
	@GetMapping("customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Customer theCustomer = customerService.getCustomer(customerId);
		
		return theCustomer;
	}
	
	//add mapping for POST/customers to add a new customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		theCustomer.setId(0);
		
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	//add mapping for PUT/customers to update an existing customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	//add mapping for DELETE/customers 
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		//retrieve the Customer to delete via the given customer id
		Customer deleteCustomer = customerService.getCustomer(customerId);
		
		//check if the deleteCustomer is null
		if (deleteCustomer == null) {
			return "There is no such customer on the file";
		}
		//
		customerService.deleteCustomer(customerId);
		
		return "Deleted customer id " + customerId;
		
	}
}
