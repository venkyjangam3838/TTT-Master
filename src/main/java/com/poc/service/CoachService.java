package com.poc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.entity.Coach;
import com.poc.repository.CoachRepository;

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


    public Optional<Coach> getCoachByHeight(double height) {
        return coachRepository.findByHeight(height); // Call repository method to get the coach
    }


}