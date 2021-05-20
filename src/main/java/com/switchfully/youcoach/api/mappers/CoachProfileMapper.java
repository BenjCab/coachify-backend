package com.switchfully.youcoach.api.mappers;

import com.switchfully.youcoach.api.CoachProfileDTO;
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
    public CoachProfileDTO toDTO(CoachProfile coach) {
        return new CoachProfileDTO()
                .setFirstName(coach.getAccount().getFirstName())
                .setLastName(coach.getAccount().getLastName())
                .setImage(coach.getImage())
                .setTopicsByCoach(topicDTOMapper.toDTOList(topicByCoachService.getAllTopicsByCoachProfile(coach)))
                .setIntroduction(coach.getIntroduction())
                .setAvailability(coach.getAvailability())
                .setEmail(coach.getAccount().getEmail())
                .setId(coach.getId());
    }
    public List<CoachProfileDTO> toDTOList(List<CoachProfile> coaches) {
        return coaches.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
