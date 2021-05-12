package com.switchfully.youcoach.domain.repositories;

import com.switchfully.youcoach.domain.entities.Coachee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Coachee, Long> {
}
