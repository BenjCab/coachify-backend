package com.switchfully.youcoach.domain.repositories;

import com.switchfully.youcoach.domain.entities.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
}
