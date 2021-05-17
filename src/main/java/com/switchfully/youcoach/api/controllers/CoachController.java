package com.switchfully.youcoach.api.controllers;

import com.switchfully.youcoach.api.dtos.OverviewCoachDTO;
import com.switchfully.youcoach.api.mappers.OverviewCoachDTOMapper;
import com.switchfully.youcoach.api.mappers.TopicDTOMapper;
import com.switchfully.youcoach.service.CoachService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coaches")
@CrossOrigin("http://localhost:4200")
public class CoachController {
    private static final Logger logger = LoggerFactory.getLogger(CoachController.class);
    private final CoachService coachService;
    private final OverviewCoachDTOMapper overviewCoachDTOMapper;
    private final TopicDTOMapper topicDTOMapper;

    public CoachController(CoachService coachService, OverviewCoachDTOMapper overviewCoachDTOMapper, TopicDTOMapper topicDTOMapper) {
        this.coachService = coachService;
        this.overviewCoachDTOMapper = overviewCoachDTOMapper;
        this.topicDTOMapper = topicDTOMapper;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<OverviewCoachDTO> getAllCoaches() {
        return overviewCoachDTOMapper.toDTOList(coachService.getAllCoaches());
    }
}
