package com.switchfully.youcoach.service;

import com.switchfully.youcoach.api.DTOs.UpdateCoachProfileDTO;
import com.switchfully.youcoach.api.mappers.CoachProfileMapper;
import com.switchfully.youcoach.api.DTOs.CoachProfileDTO;
import com.switchfully.youcoach.domain.CoachProfile;
import com.switchfully.youcoach.domain.CoachRepository;
import com.switchfully.youcoach.domain.Topic;
import com.switchfully.youcoach.domain.TopicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CoachProfileServiceImpl implements CoachProfileService {
    private final CoachRepository coachRepository;
    private final CoachProfileMapper coachProfileMapper;
    private final TopicRepository topicRepository;

    public CoachProfileServiceImpl(CoachRepository coachRepository, CoachProfileMapper coachProfileMapper, TopicRepository topicRepository) {
        this.coachRepository = coachRepository;
        this.coachProfileMapper = coachProfileMapper;
        this.topicRepository = topicRepository;
    }

    @Override
    public List<CoachProfileDTO> getAllCoachesWithCoachProfile() {
        List<CoachProfile> coachProfiles = coachRepository.findAll();
        return coachProfileMapper.toDTOList(coachProfiles);
    }

    public CoachProfile getCoachById(Long id) {
        return coachRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id not found in database"));
    }

    @Override
    public List<String> getAllTopicNames() {
        return topicRepository.findAll().stream().map(Topic::getTopicName).collect(Collectors.toList());
    }

    @Override
    public Long getCoachIdByCoacheeId(Long id) {
        if (coachRepository.getCoachProfileByAccount_Id(id) == null) {
            return 0L;
        } else {
            return coachRepository.getCoachProfileByAccount_Id(id).getId();
        }
    }

    @Override
    public UpdateCoachProfileDTO updateCoachProfile(Long id, UpdateCoachProfileDTO updateCoachProfileDTO) {
        CoachProfile coachProfile = getCoachById(id);
        coachProfile.setAvailability(updateCoachProfileDTO.getAvailability());
        coachProfile.setIntroduction(updateCoachProfileDTO.getIntroduction());
        return new UpdateCoachProfileDTO().setAvailability(coachProfile.getAvailability()).setIntroduction(updateCoachProfileDTO.getIntroduction());
    }
}
