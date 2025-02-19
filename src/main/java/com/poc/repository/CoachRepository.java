package com.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.entity.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long> {

}
