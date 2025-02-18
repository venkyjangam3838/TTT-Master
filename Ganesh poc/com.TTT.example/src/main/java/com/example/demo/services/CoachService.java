package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Coach;
import com.example.demo.entities.Customer;
import com.example.demo.repository.CoachRepository;

@Service
public class CoachService {
	@Autowired
	private CoachRepository coachRepository;

	public List<Coach> getAllCoaches() {
		return coachRepository.findAll();
	}

	public Coach getCoachById(int id) {
		return coachRepository.findById(id).orElse(null);
	}

	public Coach saveCoach(Coach coach) {
		return coachRepository.save(coach);
	}

	public void deleteCoach(int id) {
		coachRepository.deleteById(id);
	}

	public Object getCoachById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Coach addCoach(Coach coach) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
