package com.switchfully.youcoach.api;

import com.switchfully.youcoach.domain.CoachProfile;
import com.switchfully.youcoach.service.TopicByCoachService;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CoachProfileMapper {

    private final TopicByCoachService topicByCoachService;
    private final TopicDTOMapper topicDTOMapper;

    public CoachProfileMapper(TopicByCoachService topicByCoachService, TopicDTOMapper topicDTOMapper) {
        this.topicByCoachService = topicByCoachService;
        this.topicDTOMapper = topicDTOMapper;
    }
    public OverviewCoachDTO toDTO(CoachProfile coachProfile) {
        return new OverviewCoachDTO()
                .setFirstName(coachProfile.getAccount().getFirstName())
                .setLastName(coachProfile.getAccount().getLastName())
                .setImage(coachProfile.getImage())
                .setTopicsByCoach(topicDTOMapper.toDTOList(topicByCoachService.getAllTopicsByCoachProfile(coachProfile)));
    }
    public List<OverviewCoachDTO> toDTOList(List<CoachProfile> coaches) {
        return coaches.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
