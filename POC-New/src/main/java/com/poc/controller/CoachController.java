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

import com.poc.entity.Coach;
import com.poc.service.CoachService;

@RestController
@RequestMapping("/coaches")
public class CoachController {

	@Autowired
	private CoachService coachService;

	@GetMapping
	public List<Coach> getAllCoaches() {
		return coachService.getAllCoaches();
	}

	@PostMapping
	public Coach addCoach(@RequestBody Coach coach) {
		return coachService.addCoach(coach);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Coach> getCoachById(@PathVariable Long id) {
		return coachService.getCoachById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
}
