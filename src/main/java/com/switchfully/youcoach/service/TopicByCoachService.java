package com.switchfully.youcoach.service;

import com.switchfully.youcoach.domain.CoachProfile;
import com.switchfully.youcoach.domain.TopicByCoach;

import java.util.List;

public interface TopicByCoachService {
    List<TopicByCoach> getAllTopicsByCoachProfile(CoachProfile coachProfile);
}
