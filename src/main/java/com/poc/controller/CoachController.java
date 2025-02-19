package com.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.poc.entity.Coach;
import com.poc.service.CoachService;

import java.util.List;
import java.util.Optional;

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
        return coachService.saveCoach(coach); 
    }
    
    @GetMapping("/{id}")
    public Coach getCoachById(@PathVariable int id) {
      return coachService.getCoachById(id); 
    }
    
    
    
    @GetMapping("/height/{height}")
    public ResponseEntity<?> getCoachByHeight(@PathVariable double height) {
        Optional<Coach> optionalCoach = coachService.getCoachByHeight(height);
        if (optionalCoach.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK)
            	.body(optionalCoach);
        } else {
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Coach with height " + height + " not found");
        }
    }
    
    
    
    
    
    
    
    

}

