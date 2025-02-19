package com.poc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.entity.Coach;
import com.poc.repository.CoachRepository;
import com.poc.service.CoachService;

@Service
public class CoachServiceImpl implements CoachService {

	@Autowired
	private CoachRepository coachRepository;

	@Override
	public List<Coach> getAllCoaches() {
		return coachRepository.findAll();
	}

	@Override
	public Optional<Coach> getCoachById(Long id) {
		return coachRepository.findById(id);
	}

	@Override
	public Coach addCoach(Coach coach) {
		return coachRepository.save(coach);
	}
}
