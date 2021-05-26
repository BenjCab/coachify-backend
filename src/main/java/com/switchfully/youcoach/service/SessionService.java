package com.switchfully.youcoach.service;

import com.switchfully.youcoach.api.DTOs.SessionDTO;
import com.switchfully.youcoach.api.mappers.SessionMapper;
import com.switchfully.youcoach.domain.AccountImpl;
import com.switchfully.youcoach.domain.Session;
import com.switchfully.youcoach.domain.SessionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SessionService {
    private final SessionMapper sessionMapper;
    private final SessionRepository sessionRepository;
    private final AccountService accountService;

    public SessionService(SessionMapper sessionMapper, SessionRepository sessionRepository, AccountService accountService) {
        this.sessionMapper = sessionMapper;
        this.sessionRepository = sessionRepository;
        this.accountService = accountService;
    }

    public Session createSession(SessionDTO sessionDTO) {
        return sessionRepository.save(sessionMapper.toEntity(sessionDTO));
    }

    public List<Session> getAllSessions(Long accountId) {
        AccountImpl account = accountService.getUserById(accountId);
        return sessionRepository.getAllByCoachee(account).stream().map(this::updateSessionStatus).collect(Collectors.toList());
    }

    public Session updateSessionStatus(Session sessionToUpdate) {
        if (LocalDate.now().isAfter(sessionToUpdate.getDate())) {
            sessionToUpdate.setStatus("Finished (Automatically closed)");
        }
        return sessionToUpdate;
    }
}
