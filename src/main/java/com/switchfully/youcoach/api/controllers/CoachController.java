package com.switchfully.youcoach.api.controllers;

import com.switchfully.youcoach.api.CoachProfileDTO;
import com.switchfully.youcoach.api.mappers.CoachProfileMapper;
import com.switchfully.youcoach.service.CoachProfileService;
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
    private final CoachProfileService coachProfileService;
    private final CoachProfileMapper coachProfileMapper;

    public CoachController(CoachProfileService coachProfileService, CoachProfileMapper coachProfileMapper) {
        this.coachProfileService = coachProfileService;
        this.coachProfileMapper = coachProfileMapper;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CoachProfileDTO> getAllCoaches() {
        return coachProfileService.getAllCoachesWithCoachProfile();
    }

    @GetMapping(path="/{id}",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CoachProfileDTO getCoachById(@PathVariable Long id) {
        return coachProfileMapper.toDTO(coachProfileService.getCoachById(id));
    }

}
