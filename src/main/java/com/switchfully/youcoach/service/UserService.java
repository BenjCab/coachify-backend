package com.switchfully.youcoach.service;

import com.switchfully.youcoach.api.dtos.OverviewCoachDTO;
import com.switchfully.youcoach.domain.entities.Coach;
import com.switchfully.youcoach.domain.entities.Coachee;
import com.switchfully.youcoach.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Coachee addUser(Coachee coachee) {
        return userRepository.save(coachee);
    }

    public Coachee getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(id + " was not found in database."));
    }
}
