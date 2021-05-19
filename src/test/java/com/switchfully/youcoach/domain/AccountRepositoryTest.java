package com.switchfully.youcoach.domain;

import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void shouldSave() {
        AccountImpl account = AccountImpl.builder()
                .setFirstName("Testa")
                .setLastName("Test")
                .setEmail("test@test.com")
                .setPassword("password")
                .setEnabled(true)
                .setAuthorities(List.of(Authority.COACH, Authority.COACHEE))
                .build();

        accountRepository.save(account);
    }
}
