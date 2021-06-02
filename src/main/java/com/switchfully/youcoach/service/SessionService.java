package com.switchfully.youcoach.service;

import com.switchfully.youcoach.api.DTOs.SessionDTO;
import com.switchfully.youcoach.api.mappers.SessionMapper;
import com.switchfully.youcoach.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
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
    private final SessionFeedbackCoacheeRepository sessionFeedbackCoacheeRepository;
    private static final Logger logger = LoggerFactory.getLogger(SessionService.class);


    public SessionService(SessionMapper sessionMapper, SessionRepository sessionRepository, AccountService accountService, CoachProfileService coachProfileService, SessionFeedbackCoacheeRepository sessionFeedbackCoacheeRepository) {
        this.sessionMapper = sessionMapper;
        this.sessionRepository = sessionRepository;
        this.accountService = accountService;
        this.coachProfileService = coachProfileService;
        this.sessionFeedbackCoacheeRepository = sessionFeedbackCoacheeRepository;
    }

    public Session createSession(SessionDTO sessionDTO) {
        sessionDTO.setDate(sessionDTO.getDate().plusDays(1));
        logger.warn("session date : " + sessionDTO.getDate());
        logger.warn("today's date : " + LocalDate.now());
        if (!sessionDTO.getDate().isEqual(LocalDate.now())) {
            if (sessionDTO.getDate().isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("You cant ask for a session before today's date.");
            }
        }
        if (sessionDTO.getDate().isEqual(LocalDate.now()) && sessionDTO.getTime().isBefore(LocalTime.now())) {
            throw new IllegalArgumentException("You cant ask for a session for earlier today.");
        }
        return sessionRepository.save(sessionMapper.toEntity(sessionDTO));
    }

    public List<Session> getAllSessionsCoachee(Long accountId) {
        AccountImpl account = accountService.getUserById(accountId);
        return sessionRepository.getAllByCoachee(account).stream().map(this::updateAutomaticallySessionStatus).collect(Collectors.toList());
    }

    public Session updateAutomaticallySessionStatus(Session sessionToUpdate) {
        if (sessionToUpdate.getDate().isBefore(LocalDate.now()) || (sessionToUpdate.getDate().isEqual(LocalDate.now()) && LocalTime.now().isAfter(sessionToUpdate.getTime()))) {

            switch (sessionToUpdate.getStatus().toLowerCase(Locale.ROOT)) {
                case "requested":
                    sessionToUpdate.setStatus("Finished (Automatically closed)");
                    break;
                case "accepted":
                    sessionToUpdate.setStatus("Done, waiting feedback");
                    break;
                default:
                    break;
            }
        }
        return sessionToUpdate;
    }

    public List<Session> getAllSessionsCoach(Long coachId) {
        CoachProfile coachProfile = coachProfileService.getCoachById(coachId);
        return sessionRepository.getAllByCoach(coachProfile).stream().map(this::updateAutomaticallySessionStatus).collect(Collectors.toList());
    }

    public Session setSessionStatus(Long id, String status) {
        Session session = sessionRepository.getSessionBySessionId(id);
        return session.setStatus(status);
    }

    public Session getSessionById(Long id) {
        return sessionRepository.getSessionBySessionId(id);
    }

    public SessionFeedbackCoachee setSessionFeedbackCoachee(Long id, SessionFeedbackCoachee sessionFeedbackCoachee) {
        Session session = sessionRepository.getSessionBySessionId(id);
        sessionFeedbackCoacheeRepository.save(sessionFeedbackCoachee);
        return session.setSessionFeedbackCoachee(sessionFeedbackCoachee).getSessionFeedbackCoachee();
    }
}
