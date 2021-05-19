package com.switchfully.youcoach;

import com.switchfully.youcoach.domain.AccountImpl;
import com.switchfully.youcoach.domain.AccountRepository;
import com.switchfully.youcoach.infrastructure.security.authentication.user.Authority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class YoucoachApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(YoucoachApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(YoucoachApplication.class, args);
    }

    @Bean
    public CommandLineRunner initializeUsers(@Autowired AccountRepository accountRepository,
                                             @Autowired PasswordEncoder passwordEncoder) {
        return (args) -> {
            AccountImpl account = AccountImpl.builder()
                    .setFirstName("Testa")
                    .setLastName("Test")
                    .setEmail("test@test.com")
                    .setPassword(passwordEncoder.encode("password"))
                    .setEnabled(true)
                    .setAuthorities(List.of(Authority.COACH, Authority.COACHEE))
                    .build();
            accountRepository.save(account);
            LOGGER.info("Added user: " + account);
        };
    }

}
