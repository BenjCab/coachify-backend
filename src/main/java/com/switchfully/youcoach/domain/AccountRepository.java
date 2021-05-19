package com.switchfully.youcoach.domain;

import com.switchfully.youcoach.infrastructure.security.authentication.user.api.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountImpl, Long> {
    Optional<Account> getAccountImplByEmail(String email);
}
