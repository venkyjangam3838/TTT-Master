package com.example.demo.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	Optional<Customer> findById(Long id);





	

}
