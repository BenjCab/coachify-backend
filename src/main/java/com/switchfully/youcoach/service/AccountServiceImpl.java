package com.switchfully.youcoach.service;

import com.switchfully.youcoach.domain.AccountImpl;
import com.switchfully.youcoach.domain.AccountRepository;
import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;
import com.switchfully.youcoach.infrastructure.security.authentication.user.api.Account;
import com.switchfully.youcoach.infrastructure.security.authentication.user.api.AccountService;
import com.switchfully.youcoach.infrastructure.security.authentication.user.api.CreateSecuredUserDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> findByEmail(String email) {
        return accountRepository.getAccountImplByEmail(email);
    }

    @Override
    public Account createAccount(CreateSecuredUserDto createSecuredUserDto) {
        AccountImpl build = AccountImpl.builder()
                .setFirstName(createSecuredUserDto.getFirstName())
                .setLastName(createSecuredUserDto.getLastName())
                .setEmail(createSecuredUserDto.getEmail())
                .setPassword(createSecuredUserDto.getPassword())
                .setAuthorities(List.of(Authority.COACHEE))
                .build();
        return accountRepository.save(build);
    }

    @Override
    public boolean existsByEmail(String email) {
        return findByEmail(email).isPresent();
    }
}
