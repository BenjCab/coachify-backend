package com.switchfully.youcoach.api.mappers;


import com.switchfully.youcoach.api.dtos.OverviewCoachDTO;
import com.switchfully.youcoach.domain.entities.Coach;
import com.switchfully.youcoach.service.TopicByCoachService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class OverviewCoachDTOMapper {

    private final TopicByCoachService topicByCoachService;
    private final TopicDTOMapper topicDTOMapper;

    public OverviewCoachDTOMapper(TopicByCoachService topicByCoachService, TopicDTOMapper topicDTOMapper) {
        this.topicByCoachService = topicByCoachService;
        this.topicDTOMapper = topicDTOMapper;
    }



    public OverviewCoachDTO toDTO(Coach coach) {
        return new OverviewCoachDTO()
                .setFirstName(coach.getCoachee().getFirstName())
                .setLastName(coach.getCoachee().getLastName())
                .setImage(coach.getImage())
                .setTopicsByCoach(topicDTOMapper.toDTOList(topicByCoachService.getAllTopicsByCoachId(coach)))
                .setIntroduction(coach.getIntroduction())
                .setAvailability(coach.getAvailability())
                .setEmail(coach.getCoachee().getEmail())
                .setId(coach.getId());

    }

    public List<OverviewCoachDTO> toDTOList (List<Coach> coaches) {
        return coaches.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
