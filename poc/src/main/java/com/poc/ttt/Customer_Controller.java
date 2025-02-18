package com.poc.ttt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class Customer_Controller {

	@Autowired
	  private Customer_Repository customerRepository;
	  
	  @GetMapping
	  public List<Customer> getAllCustomers() {
	    return customerRepository.findAll();
	  }
	  
	  @GetMapping("/{id}")
	  public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
	    Customer customer = customerRepository.findById(id).orElse(null);
	    if (customer != null) {
	      return ResponseEntity.ok(customer);
	    } else {
	      return ResponseEntity.notFound().build();
	    }
	  }
	  
	  @PostMapping
	  public Customer addCustomer(@RequestBody Customer customer) {
	    return customerRepository.save(customer);
	  }

}
