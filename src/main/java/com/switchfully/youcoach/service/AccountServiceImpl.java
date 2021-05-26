package com.switchfully.youcoach.service;

import com.switchfully.youcoach.api.DTOs.ResetPasswordDTO;
import com.switchfully.youcoach.domain.AccountImpl;
import com.switchfully.youcoach.domain.AccountRepository;
import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;
import com.switchfully.youcoach.api.Account;
import com.switchfully.youcoach.infrastructure.security.authentication.user.api.CreateSecuredUserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<AccountImpl> findByEmail(String email) {
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

    @Override
    public AccountImpl getUserById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(id + " was not found in database."));

    }

    @Override
    public List<Account> getCoaches() {
        return accountRepository.getAccountImplsByAuthoritiesContaining(Authority.COACH);
    }

    @Override
    public boolean resetPassword(ResetPasswordDTO resetPasswordDTO) {
        AccountImpl account = accountRepository.getAccountImplByEmail(resetPasswordDTO.getEmail()).orElseThrow(()->new IllegalArgumentException("This email was not found"));
        if (!account.getResetPasswordToken().equals(resetPasswordDTO.getResetPasswordId())){
            throw new IllegalArgumentException("Wrong password reset ID " + resetPasswordDTO.getResetPasswordId() + " " + account.getResetPasswordToken());
        }
        account.setPassword(passwordEncoder.encode(resetPasswordDTO.getPassword()));
        account.setResetPasswordToken(null);
        return true;
    }
    @Override
    public boolean resetPasswordTokenExist(String resetPasswordId) {
        return accountRepository.existsAccountImplByResetPasswordToken(resetPasswordId);
    }
//    @Bean
//    public JavaMailSender getJavaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//
//        mailSender.setUsername("coachify.mail.service@gmail.com");
//        mailSender.setPassword("Coachify123456");
//
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true");
//
//        return mailSender;
//    }
}
