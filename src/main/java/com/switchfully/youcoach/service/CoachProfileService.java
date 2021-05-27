package com.switchfully.youcoach.service;

import com.switchfully.youcoach.api.DTOs.CoachProfileDTO;
import com.switchfully.youcoach.domain.CoachProfile;

import java.util.List;

public interface CoachProfileService {
    List<CoachProfileDTO> getAllCoachesWithCoachProfile();
    CoachProfile getCoachById(Long id);

    List<String> getAllTopicNames();
}
