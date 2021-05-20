package com.switchfully.youcoach.service;

import com.switchfully.youcoach.api.mappers.CoachProfileMapper;
import com.switchfully.youcoach.api.CoachProfileDTO;
import com.switchfully.youcoach.domain.CoachProfile;
import com.switchfully.youcoach.domain.CoachRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CoachProfileServiceImpl implements CoachProfileService {
    private final CoachRepository coachRepository;
    private final CoachProfileMapper coachProfileMapper;

    public CoachProfileServiceImpl(CoachRepository coachRepository, CoachProfileMapper coachProfileMapper) {
        this.coachRepository = coachRepository;
        this.coachProfileMapper = coachProfileMapper;
    }

    @Override
    public List<CoachProfileDTO> getAllCoachesWithCoachProfile() {
        List<CoachProfile> coachProfiles = coachRepository.findAll();
        return coachProfileMapper.toDTOList(coachProfiles);
    }

    public CoachProfile getCoachById(Long id) {
        return coachRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id not found in database"));
    }

}
