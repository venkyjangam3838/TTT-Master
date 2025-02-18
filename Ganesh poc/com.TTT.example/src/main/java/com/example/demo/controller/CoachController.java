package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Coach;
import com.example.demo.entities.Customer;
import com.example.demo.repository.CoachRepository;
import com.example.demo.services.CoachService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/coach")
public class CoachController {
	@Autowired

    private final CoachRepository coachRepository;

    public CoachController(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    // 1. Fetch list of all coaches
    @GetMapping
    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    // 2. Fetch a coach by ID
    @GetMapping("/{id}")
    public ResponseEntity<Coach> getCoachById(@PathVariable int id) {
        Optional<Coach> coach = coachRepository.findById(id);
        return coach.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 3. Add a new coach
    @PostMapping
    public ResponseEntity<Coach> addCoach(@RequestBody Coach coach) {
        Coach savedCoach = coachRepository.save(coach);
        return ResponseEntity.ok(savedCoach);
    }
}
