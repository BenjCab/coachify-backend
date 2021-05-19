package com.switchfully.youcoach.service;

import com.switchfully.youcoach.domain.entities.Coach;
import com.switchfully.youcoach.domain.entities.TopicByCoach;
import com.switchfully.youcoach.domain.repositories.CoachRepository;
import com.switchfully.youcoach.domain.repositories.TopicByCoachRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CoachService {
    private final CoachRepository coachRepository;


    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    public Coach getCoachById(Long id) {
        return coachRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id not found in database"));
    }
}
