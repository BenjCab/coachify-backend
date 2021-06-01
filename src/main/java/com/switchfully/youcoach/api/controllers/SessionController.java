package com.switchfully.youcoach.api.controllers;

import com.switchfully.youcoach.api.DTOs.SessionDTO;
import com.switchfully.youcoach.api.mappers.SessionMapper;
import com.switchfully.youcoach.service.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("http://localhost:4200")
public class SessionController {
    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);
    private final SessionService sessionService;
    private final SessionMapper sessionMapper;


    public SessionController(SessionService sessionService, SessionMapper sessionMapper) {
        this.sessionService = sessionService;
        this.sessionMapper = sessionMapper;
    }

    @PostMapping(produces = "application/json", consumes = "application/json", path = "/sessions")
    @ResponseStatus(HttpStatus.CREATED)
    public SessionDTO createSession(@RequestBody SessionDTO sessionDTO) {
        logger.info("received a session request for this date : " + sessionDTO.getDate());
        sessionDTO.setStatus("Requested");
        return sessionMapper.toDTO(sessionService.createSession(sessionDTO));
    }

    @PreAuthorize("hasAnyAuthority('COACHEE, ADMIN')")
    @GetMapping(produces = "application/json", path = "coachees/{id}/sessions")
    @ResponseStatus(HttpStatus.OK)
    public List<SessionDTO> getSessionsCoachee(@PathVariable Long id) {
        logger.info("getting all sessions from the coachee: " + id);
        return sessionMapper.toDTOList(sessionService.getAllSessionsCoachee(id));
    }

    @PreAuthorize("hasAnyAuthority('COACH, ADMIN')")
    @GetMapping(produces = "application/json", path = "coaches/{id}/sessions")
    @ResponseStatus(HttpStatus.OK)
    public List<SessionDTO> getSessionsCoach(@PathVariable Long id) {
        logger.info("getting all sessions from the coach: " + id);
        return sessionMapper.toDTOList(sessionService.getAllSessionsCoach(id));
    }

    @PreAuthorize("hasAnyAuthority('COACH, ADMIN')")
    @PostMapping(consumes = "application/json", path = "sessions/{id}/set-status")
    @ResponseStatus(HttpStatus.CREATED)
    public SessionDTO setSessionStatus(@RequestBody SessionDTO sessionDTO, @PathVariable Long id) {
        logger.info("Setting the status of session " + id + " to: " + sessionDTO.getStatus());
        return sessionMapper.toDTO(sessionService.setSessionStatus(id, sessionDTO.getStatus()));
    }

}
