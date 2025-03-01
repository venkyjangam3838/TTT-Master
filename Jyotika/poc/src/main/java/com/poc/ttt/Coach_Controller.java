package com.poc.ttt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coaches")
public class Coach_Controller {
	
	@Autowired
	  private Coach_Repository coachRepository;
	  
	  @GetMapping
	  public List<Coach> getAllCoaches() {
	    return coachRepository.findAll();
	  }
	  
	  @GetMapping("/{id}")
	  public ResponseEntity<Coach> getCoachById(@PathVariable Long id) {
	    Coach coach = coachRepository.findById(id).orElse(null);
	    if (coach != null) {
	      return ResponseEntity.ok(coach);
	    } else {
	      return ResponseEntity.notFound().build();
	    }
	  }
	  
	  @PostMapping
	  public Coach addCoach(@RequestBody Coach coach) {
	    return coachRepository.save(coach);
	  }


}
