package com.switchfully.youcoach.domain;

import com.switchfully.youcoach.api.Account;
import com.switchfully.youcoach.infrastructure.security.authentication.jwt.JwtGenerator;
import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JwtGenerator jwtGenerator;

    @Test
    void shouldSave() {
        AccountImpl account = AccountImpl.builder()
                .setFirstName("Summer")
                .setLastName("Smith")
                .setEmail("test@test.com")
                .setPassword("password")
                .setEnabled(true)
                .setAuthorities(List.of(Authority.COACH, Authority.COACHEE))
                .build();

        Account account1 = accountRepository.save(account);

        Assertions.assertEquals(account.getFirstName(), account1.getFirstName());
        Assertions.assertEquals(account.getLastName(), account1.getLastName());
        Assertions.assertEquals(account.getEmail(), account1.getEmail());
        Assertions.assertEquals(account.getId(), account1.getId());
        Assertions.assertEquals(account.getPassword(), account1.getPassword());

        accountRepository.delete(account);
    }

    @Test
    void shouldFindUserById() {
        AccountImpl account = AccountImpl.builder()
                .setFirstName("Foo")
                .setLastName("Bar")
                .setEmail("account@test.com")
                .setPassword("password")
                .setEnabled(true)
                .setAuthorities(List.of(Authority.COACH, Authority.COACHEE))
                .build();

        accountRepository.save(account);

        AccountImpl account1 = accountRepository.findById(account.getId()).orElseThrow();

        Assertions.assertEquals(account.toString(), account1.toString());

        accountRepository.delete(account);
    }

    @Test
    void shouldGetAccountsByAuthoritiesContaining() {
        List<Account> accounts = accountRepository.getAccountImplsByAuthoritiesContaining(Authority.COACH);

        Assertions.assertTrue(accounts.get(0).getAuthorities().contains(Authority.COACH));
    }

    @Test
    void shouldReturnTrueIfAccountImplByResetPasswordToken() {
        AccountImpl account = AccountImpl.builder()
                .setFirstName("Testa")
                .setLastName("Test")
                .setEmail("morty@smith.com")
                .setPassword("password")
                .setEnabled(true)
                .setAuthorities(List.of(Authority.COACH, Authority.COACHEE))
                .build();

        String token = jwtGenerator.generateToken(account);
        account.setResetPasswordToken(token);

        boolean foo = accountRepository.existsAccountImplByResetPasswordToken(token);

        Assertions.assertFalse(foo);
    }

    @Test
    void shouldGetAccountImplByEmail() {
        AccountImpl account = AccountImpl.builder()
                .setFirstName("Testa")
                .setLastName("Test")
                .setEmail("rick@sanchez.com")
                .setPassword("password")
                .setEnabled(true)
                .setAuthorities(List.of(Authority.COACH, Authority.COACHEE))
                .build();

        accountRepository.save(account);

        AccountImpl account1 = accountRepository.getAccountImplByEmail("rick@sanchez.com")
                .orElseThrow();

        Assertions.assertEquals(account.getId(), account1.getId());
        Assertions.assertEquals(account.getEmail(), account1.getEmail());

        accountRepository.delete(account);
    }
}
