package com.switchfully.youcoach.domain;

import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;
import com.switchfully.youcoach.api.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountImpl, Long> {
    Optional<AccountImpl> getAccountImplByEmail(String email);
    List<Account> getAccountImplsByAuthoritiesContaining(Authority authority);
    boolean existsAccountImplByResetPasswordToken(String token);
}
