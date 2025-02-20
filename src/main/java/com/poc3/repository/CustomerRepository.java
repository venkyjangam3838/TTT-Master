package com.poc3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc3.entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Optional<Customer> findById(Long id);
}