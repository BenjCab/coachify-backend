package com.switchfully.youcoach.api.mappers;

import com.switchfully.youcoach.api.DTOs.SessionDTO;
import com.switchfully.youcoach.domain.Session;
import com.switchfully.youcoach.service.AccountService;
import com.switchfully.youcoach.service.CoachProfileService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SessionMapper {
    private final CoachProfileService coachService;
    private final AccountService coacheeService;

    public SessionMapper(CoachProfileService coachService, AccountService coacheeService) {
        this.coachService = coachService;
        this.coacheeService = coacheeService;
    }

    public SessionDTO toDTO(Session session) {
        return new SessionDTO()
                .setSessionId(session.getSessionId())
                .setCoacheeId(session.getCoachee().getId())
                .setCoachId(session.getCoach().getId())
                .setCoachFirstName(session.getCoach().getAccount().getFirstName())
                .setCoachLastName(session.getCoach().getAccount().getLastName())
                .setDate(session.getDate())
                .setTime(session.getTime())
                .setSubject(session.getSubject())
                .setLocation(session.getLocation())
                .setRemarks(session.getRemarks())
                .setStatus(session.getStatus());
    }

    public Session toEntity(SessionDTO sessionDTO) {
        return new Session()
                .setCoachee(coacheeService.getUserById(sessionDTO.getCoacheeId()))
                .setCoach(coachService.getCoachById(sessionDTO.getCoachId()))
                .setDate(sessionDTO.getDate())
                .setTime(sessionDTO.getTime())
                .setSubject(sessionDTO.getSubject())
                .setLocation(sessionDTO.getLocation())
                .setRemarks(sessionDTO.getRemarks())
                .setStatus(sessionDTO.getStatus());
    }

    public List<SessionDTO> toDTOList(List<Session> sessions) {
        return sessions.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
