package com.switchfully.youcoach.service;

import com.switchfully.youcoach.api.CoachProfileMapper;
import com.switchfully.youcoach.api.OverviewCoachDTO;
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
    public List<OverviewCoachDTO> getAllCoachesWithCoachProfile() {
        List<CoachProfile> coachProfiles = coachRepository.findAll();
        return coachProfileMapper.toDTOList(coachProfiles);
    }

}
