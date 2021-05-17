package com.switchfully.youcoach.domain.repositories;

import com.switchfully.youcoach.domain.entities.Coach;
import com.switchfully.youcoach.domain.entities.TopicByCoach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicByCoachRepository extends JpaRepository<TopicByCoach, Long> {
    List<TopicByCoach> getAllByCoach(Coach coach);
}
