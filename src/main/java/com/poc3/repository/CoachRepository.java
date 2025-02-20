package com.poc3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc3.entity.Coach;



public interface CoachRepository extends JpaRepository<Coach, Integer> {

	Optional<Coach> findById(Long id);
}