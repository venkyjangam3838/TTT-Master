package com.poc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long> {

	void deleteById(int id);

	Optional<Coach> findById(int id);

}
