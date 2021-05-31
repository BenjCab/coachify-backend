package com.switchfully.youcoach.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> getAllByCoachee(AccountImpl account);
    List<Session> getAllByCoach (CoachProfile profile);
    Session getSessionBySessionId (long ID);
}
