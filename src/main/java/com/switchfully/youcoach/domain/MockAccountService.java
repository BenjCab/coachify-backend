package com.switchfully.youcoach.domain;

import com.switchfully.youcoach.infrastructure.security.authentication.user.api.AccountService;
import com.switchfully.youcoach.infrastructure.security.authentication.user.api.CreateSecuredUserDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MockAccountService implements AccountService {

    @Override
    public Optional<MockAccount> findByEmail(String userName) {
        return Optional.empty();
    }

    @Override
    public MockAccount createAccount(CreateSecuredUserDto createSecuredUserDto) {
        return null;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }
}
