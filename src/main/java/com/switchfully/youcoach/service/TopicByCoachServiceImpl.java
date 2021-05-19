package com.switchfully.youcoach.service;

import com.switchfully.youcoach.domain.CoachProfile;
import com.switchfully.youcoach.domain.TopicByCoach;
import com.switchfully.youcoach.domain.TopicByCoachRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TopicByCoachServiceImpl implements TopicByCoachService {
    private final TopicByCoachRepository topicByCoachRepository;

    public TopicByCoachServiceImpl(TopicByCoachRepository topicByCoachRepository) {
        this.topicByCoachRepository = topicByCoachRepository;
    }

    @Override
    public List<TopicByCoach> getAllTopicsByCoachProfile(CoachProfile coachProfile) {
        return topicByCoachRepository.getAllByCoachProfile(coachProfile);
    }
}




