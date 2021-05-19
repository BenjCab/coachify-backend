package com.switchfully.youcoach.service;

import com.switchfully.youcoach.api.OverviewCoachDTO;
import com.switchfully.youcoach.domain.CoachProfile;

import java.util.List;

public interface CoachProfileService {
    List<OverviewCoachDTO> getAllCoachesWithCoachProfile();
}
