package com.switchfully.youcoach.service;

import com.switchfully.youcoach.api.Account;
import com.switchfully.youcoach.api.DTOs.ResetPasswordDTO;
import com.switchfully.youcoach.domain.AccountImpl;
import com.switchfully.youcoach.infrastructure.security.authentication.user.api.CreateSecuredUserDto;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Optional<? extends Account> findByEmail(String userName);

    Account createAccount(CreateSecuredUserDto createSecuredUserDto);

    boolean existsByEmail(String email);

    AccountImpl getUserById(Long id);

    List<Account> getCoaches();
    boolean resetPassword(ResetPasswordDTO resetPasswordDTO);
    boolean resetPasswordTokenExist(String resetPasswordId);

    Boolean createResetPasswordProcedure(String email);
}
