package com.switchfully.youcoach.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicByCoachRepository extends JpaRepository<TopicByCoach, Long> {
    List<TopicByCoach> getAllByCoachProfile(CoachProfile coachProfile);
}
