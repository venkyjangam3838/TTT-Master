package com.poc.service;

import java.util.List;
import java.util.Optional;

import com.poc.entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();

	Optional<Customer> getCustomerById(Long id);

	Customer addCustomer(Customer customer);
}
