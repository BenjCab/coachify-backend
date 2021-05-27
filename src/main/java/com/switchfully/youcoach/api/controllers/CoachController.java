package com.switchfully.youcoach.api.controllers;

import com.switchfully.youcoach.api.DTOs.CoachProfileDTO;
import com.switchfully.youcoach.api.mappers.CoachProfileMapper;
import com.switchfully.youcoach.service.CoachProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("http://localhost:4200")
public class CoachController {
    private static final Logger logger = LoggerFactory.getLogger(CoachController.class);
    private final CoachProfileService coachProfileService;
    private final CoachProfileMapper coachProfileMapper;

    public CoachController(CoachProfileService coachProfileService, CoachProfileMapper coachProfileMapper) {
        this.coachProfileService = coachProfileService;
        this.coachProfileMapper = coachProfileMapper;
    }


    @GetMapping(path = "/coaches", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CoachProfileDTO> getAllCoaches() {
        return coachProfileService.getAllCoachesWithCoachProfile();
    }

    @GetMapping(path = "/coaches/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CoachProfileDTO getCoachById(@PathVariable Long id) {
        return coachProfileMapper.toDTO(coachProfileService.getCoachById(id));
    }

    @GetMapping(path="/users/{id}/coach", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Long getCoachIdByCoacheeId(@PathVariable Long id){
        return coachProfileService.getCoachIdByCoacheeId(id);
    }

    @GetMapping(path="/coaches/topicNames",produces ="application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getAllTopicNames(){
        return coachProfileService.getAllTopicNames();
    }

}
