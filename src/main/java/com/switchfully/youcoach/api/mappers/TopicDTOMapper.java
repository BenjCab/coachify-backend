package com.switchfully.youcoach.api.mappers;

import com.switchfully.youcoach.api.dtos.TopicDTO;
import com.switchfully.youcoach.domain.entities.TopicByCoach;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TopicDTOMapper {
    public TopicDTO toDTO(TopicByCoach topicByCoach) {
        return new TopicDTO()
                .setTopicName(topicByCoach.getTopic().getName())
                .setGrade1(topicByCoach.getGrade1())
                .setGrade2(topicByCoach.getGrade2())
                .setGrade3(topicByCoach.getGrade3());
    }

    public List<TopicDTO> toDTOList(List<TopicByCoach> topicByCoachList) {
        return topicByCoachList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
