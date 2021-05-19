package com.switchfully.youcoach.api;

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
    private final AccountMapper accountMapper;

    public CoachController(CoachProfileService coachProfileService, AccountMapper accountMapper) {
        this.coachProfileService = coachProfileService;
        this.accountMapper = accountMapper;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<OverviewCoachDTO> getAllCoaches() {
        return coachProfileService.getAllCoachesWithCoachProfile();
    }
}
