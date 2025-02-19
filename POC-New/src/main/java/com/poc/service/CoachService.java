package com.poc.service;

import java.util.List;
import java.util.Optional;

import com.poc.entity.Coach;

public interface CoachService{
	List<Coach> getAllCoaches();

	Optional<Coach> getCoachById(Long id);

	Coach addCoach(Coach coach);
}
