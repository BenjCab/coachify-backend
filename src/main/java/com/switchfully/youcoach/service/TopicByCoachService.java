package com.switchfully.youcoach.service;

import com.switchfully.youcoach.domain.entities.Coach;
import com.switchfully.youcoach.domain.entities.TopicByCoach;
import com.switchfully.youcoach.domain.repositories.TopicByCoachRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TopicByCoachService {
    private final TopicByCoachRepository topicByCoachRepository;

    public TopicByCoachService(TopicByCoachRepository topicByCoachRepository) {
        this.topicByCoachRepository = topicByCoachRepository;
    }

    public List<TopicByCoach> getAllTopicsByCoachId(Coach coach) {
        return topicByCoachRepository.getAllByCoach(coach);
    }
}
