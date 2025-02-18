package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Coach;
import com.example.demo.entities.Customer;
import com.example.demo.repository.CoachRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.services.CustomerService;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	 @Autowired

	    private final CustomerRepository customerRepository;
	    private final CoachRepository coachRepository;

	    public CustomerController(CustomerRepository customerRepository, CoachRepository coachRepository) {
	        this.customerRepository = customerRepository;
	        this.coachRepository = coachRepository;
	    }

	    // 1. Fetch list of all customers
	    @GetMapping
	    public List<Customer> getAllCustomers() {
	        return customerRepository.findAll();
	    }

	    // 2. Fetch a customer by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
	        Optional<Customer> customer = customerRepository.findById(id);
	        return customer.map(ResponseEntity::ok)
	                       .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    // 3. Add a new customer
	    @PostMapping
	    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
	        if (customer.getCoach() != null) {
	            Optional<Coach> coach = coachRepository.findById(customer.getCoach().getId());
	            coach.ifPresent(customer::setCoach);
	        }
	        Customer savedCustomer = customerRepository.save(customer);
	        return ResponseEntity.ok(savedCustomer);
	    }
}
