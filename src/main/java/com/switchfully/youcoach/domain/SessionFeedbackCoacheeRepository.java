package com.switchfully.youcoach.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionFeedbackCoacheeRepository extends JpaRepository<SessionFeedbackCoachee, Long> {

}
