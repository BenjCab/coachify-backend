package com.switchfully.youcoach.service;

import com.switchfully.youcoach.api.DTOs.SessionDTO;
import com.switchfully.youcoach.api.controllers.SessionController;
import com.switchfully.youcoach.api.mappers.SessionMapper;
import com.switchfully.youcoach.domain.AccountImpl;
import com.switchfully.youcoach.domain.CoachProfile;
import com.switchfully.youcoach.domain.Session;
import com.switchfully.youcoach.domain.SessionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@Transactional
public class SessionService {
    private final SessionMapper sessionMapper;
    private final SessionRepository sessionRepository;
    private final AccountService accountService;
    private final CoachProfileService coachProfileService;
    private static final Logger logger = LoggerFactory.getLogger(SessionService.class);

    public SessionService(SessionMapper sessionMapper, SessionRepository sessionRepository, AccountService accountService, CoachProfileService coachProfileService) {
        this.sessionMapper = sessionMapper;
        this.sessionRepository = sessionRepository;
        this.accountService = accountService;
        this.coachProfileService = coachProfileService;
    }

    public Session createSession(SessionDTO sessionDTO) {
        //logger.warn("session date : "+sessionDTO.getDate());
        //logger.warn("today's date : "+LocalDate.now());
//        if (!sessionDTO.getDate().isEqual(LocalDate.now())) {
//            if (sessionDTO.getDate().isBefore(LocalDate.now())) {
//                throw new IllegalArgumentException("You cant ask for a session before today's date.");
//            }
//        }
//        if (sessionDTO.getDate().isEqual(LocalDate.now()) && sessionDTO.getTime().isBefore(LocalTime.now())) {
//            throw new IllegalArgumentException("You cant ask for a session for earlier today.");
//        }
        return sessionRepository.save(sessionMapper.toEntity(sessionDTO));
    }

    public List<Session> getAllSessionsCoachee(Long accountId) {
        AccountImpl account = accountService.getUserById(accountId);
        return sessionRepository.getAllByCoachee(account).stream().map(this::updateSessionStatus).collect(Collectors.toList());
    }

    //todo change name + expand this with time + perhaps other reasoning
    public Session updateSessionStatus(Session sessionToUpdate) {
        if (LocalDate.now().isAfter(sessionToUpdate.getDate()) && LocalTime.now().isAfter(sessionToUpdate.getTime())) {
            switch (sessionToUpdate.getStatus().toLowerCase(Locale.ROOT)) {
                case "Requested":
                    sessionToUpdate.setStatus("Finished (Automatically closed)");
                    break;
                case "Accepted":
                    sessionToUpdate.setStatus("Done, waiting feedback");
                    break;
                case "Declined":
                    sessionToUpdate.setStatus("Finished (declined)");
                    break;
                default:
                    break;
            }
            sessionToUpdate.setStatus("Finished (Automatically closed)");
        }
        return sessionToUpdate;
    }

    public List<Session> getAllSessionsCoach(Long coachId) {
        CoachProfile coachProfile = coachProfileService.getCoachById(coachId);
        return sessionRepository.getAllByCoach(coachProfile).stream().map(this::updateSessionStatus).collect(Collectors.toList());
    }

    public Session setSessionStatus(Long id, String status) {
        Session session = sessionRepository.getSessionBySessionId(id);
        return session.setStatus(status);
    }
}
