package com.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.Coach;
import com.poc.repository.CoachRepository;

@RestController
@RequestMapping("/coaches")
public class CoachController {

	@Autowired
	private CoachRepository coachRepository;

	@GetMapping
	public List<Coach> getAllCoaches() {
		return coachRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Coach> getCoachById(@PathVariable Long id) {
		return coachRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Coach addCoach(@RequestBody Coach coach) {
		return coachRepository.save(coach);
	}
}
