package com.poc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.Customer;
import com.poc.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    
    
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    
	public boolean deleteCustomerId(int id) {
	boolean b =  customerRepository.existsById(id);
	if(b) {
		 customerRepository.deleteById(id);
		 return true;
	}else {
		return false;
	}
	
	}
}